/*
 * Copyright (C) 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.teleport.templates.custom;

import com.google.api.services.bigquery.model.TableCell;
import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.api.services.bigquery.model.TableRow;
import com.google.api.services.bigquery.model.TableSchema;

import com.google.cloud.dlp.v2.DlpServiceClient;
import com.google.privacy.dlp.v2.*;
import com.google.privacy.dlp.v2.DeidentifyContentRequest.Builder;

import com.google.cloud.teleport.metadata.Template;
import com.google.cloud.teleport.metadata.TemplateCategory;
import com.google.cloud.teleport.metadata.TemplateParameter;
import com.google.cloud.teleport.templates.SchemaParser;
import com.google.cloud.teleport.templates.custom.DLPDeidentifyGCSToBigQueryBatch.TokenizePipelineOptions;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.coders.KvCoder;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.*;
import org.apache.beam.sdk.io.FileIO.ReadableFile;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
import org.apache.beam.sdk.io.range.OffsetRange;
import org.apache.beam.sdk.metrics.Distribution;
import org.apache.beam.sdk.metrics.Metrics;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.Validation.Required;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.beam.sdk.options.ValueProvider.NestedValueProvider;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.transforms.splittabledofn.OffsetRangeTracker;
import org.apache.beam.sdk.transforms.splittabledofn.RestrictionTracker;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionView;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The {@link DLPDeidentifyGCSToBigQueryBatch} is a batching pipeline that reads
 * CSV
 * files from a
 * storage location (e.g. Google Cloud Storage), uses Cloud DLP API to inspect,
 * classify, and mask
 * sensitive information (e.g. PII Data like passport or SIN number) and at the
 * end stores
 * obfuscated data in BigQuery (Dynamic Table Creation) to be used for various
 * purposes. e.g. data
 * analytics, ML model. Cloud DLP inspection and masking can be configured by
 * the user and can make
 * use of over 90 built in detectors and masking techniques like tokenization,
 * secure hashing, date
 * shifting, partial masking, and more.
 *
 * <p>
 * <b>Pipeline Requirements</b>
 *
 * <ul>
 * <li>DLP Templates exist (e.g. deidentifyTemplate, InspectTemplate)
 * <li>The BigQuery Dataset exists
 * </ul>
 *
 * <p>
 * <b>Example Usage</b>
 *
 * <pre>
 * # Set the pipeline vars
 * export PROJECT_ID="ext-pinetree"
 * export BUCKET_NAME=""
 *
 * PIPELINE_FOLDER=gs://${BUCKET_NAME}/dataflow/pipelines/dlp-text-to-bigquery
 *
 * # Set the runner
 * RUNNER=DataflowRunner
 *
 * # Build the template
 * mvn compile exec:java \
 * -Dexec.mainClass=com.google.cloud.teleport.templates.custom.DLPDeidentifyGCSToBigQueryBatch \
 * -Dexec.cleanupDaemonThreads=false \
 * -Dexec.args=" \
 * --project=${PROJECT_ID} \
 * --stagingLocation=${PIPELINE_FOLDER}/staging \
 * --tempLocation=${PIPELINE_FOLDER}/temp \
 * --templateLocation=${PIPELINE_FOLDER}/template \
 * --runner=${RUNNER}"
 *
 * # Execute the template
 * JOB_NAME=dlp-text-to-bigquery-$USER-`date +"%Y%m%d-%H%M%S%z"`
 *
 * gcloud dataflow jobs run ${JOB_NAME} \
 * --gcs-location=${PIPELINE_FOLDER}/template \
 * --zone=us-east1-d \
 * --parameters \
 * "inputFilePattern=gs://<bucketName>/<fileName>.csv, batchSize=15,datasetName=<BQDatasetId>,
 *  dlpProjectId=<projectId>,
 *  deidentifyTemplateName=projects/{projectId}/deidentifyTemplates/{deIdTemplateId}
 * </pre>
 */
@Template(name = "Batch_DLP_GCS_to_BigQuery_Deidentify", category = TemplateCategory.BATCH, displayName = "Data Masking/Tokenization from Cloud Storage to BigQuery (using Cloud DLP)", description = "An example pipeline that reads CSV files from Cloud Storage, uses Cloud DLP API to mask and tokenize data based on the DLP templates provided and stores output in BigQuery. Note, not all configuration settings are available in this default template. You may need to deploy a custom template to accommodate your specific environment and data needs. More details here: https://cloud.google.com/solutions/de-identification-re-identification-pii-using-cloud-dlp", optionsClass = TokenizePipelineOptions.class, contactInformation = "https://cloud.google.com/support")
public class DLPDeidentifyGCSToBigQueryBatch {

	public static final Logger LOG = LoggerFactory.getLogger(DLPDeidentifyGCSToBigQueryBatch.class);

	private static final String BIGQUERY_SCHEMA = "BigQuery Schema";
	private static final String NAME = "name";
	private static final String TYPE = "type";
	private static final String MODE = "mode";
	/** Expected only CSV file in GCS bucket. */
	private static final String ALLOWED_FILE_EXTENSION = String.valueOf("csv.gz");
	/** Regular expression that matches valid BQ table IDs. */
	private static final Pattern TABLE_REGEXP = Pattern.compile("[-\\w$@]{1,1024}");
	/** Default batch size if value not provided in execution. */
	private static final Integer DEFAULT_BATCH_SIZE = 1000;
	/** Regular expression that matches valid BQ column name . */
	private static final Pattern COLUMN_NAME_REGEXP = Pattern.compile("^[A-Za-z_]+[A-Za-z_0-9]*$");

	/**
	 * Main entry point for executing the pipeline. This will run the pipeline
	 * asynchronously. If
	 * blocking execution is required, use the {@link
	 * DLPDeidentifyGCSToBigQueryBatch#run(TokenizePipelineOptions)} method to start
	 * the
	 * pipeline and
	 * invoke {@code result.waitUntilFinish()} on the {@link PipelineResult}
	 *
	 * @param args The command-line arguments to the pipeline.
	 */
	public static void main(String[] args) {
		// Example parameters
		String[] pipelineOptions = {
				"--experiments=use_runner_v2",
				"--runner=DataflowRunner",
				"--project=ext-pinetree",
				"--region=asia-southeast1",
				"--subnetwork=https://www.googleapis.com/compute/v1/projects/ext-pinetree/regions/asia-southeast1/subnetworks/poc-subnet",

				"--numWorkers=2",
				"--maxNumWorkers=10",
				"--numberOfWorkerHarnessThreads=12",
				"--workerMachineType=n2-standard-8",
				"--dlpProjectId=ext-pinetree",

				"--deidentifyTemplateName=projects/ext-pinetree/locations/global/deidentifyTemplates/8469641006640120691",
				"--JSONPath=gs://dlp-dataflow/schema/tab_account.json",
				"--outputTable=ext-pinetree:input_raw.TAB_ACCOUNT",
				"--inputFilePattern=gs://ext-pinetree-staging-dlp-data/2022_12_19_093345/tab_account/tab_account-*.csv.gz",

				"--bigQueryLoadingTemporaryDirectory=gs://dlp-dataflow/bigquery/temp_dir"
		};

		TokenizePipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation()
				.as(TokenizePipelineOptions.class);
		run(options);
	}

	/**
	 * Runs the pipeline with the supplied options.
	 *
	 * @param options The execution parameters to the pipeline.
	 * @return The result of the pipeline execution.
	 */
	public static PipelineResult run(TokenizePipelineOptions options) {
		// Create the pipeline
		Pipeline p = Pipeline.create(options);

		/*
		 * Steps:
		 * 1) Read from the text source continuously based on default interval e.g. 30
		 * seconds
		 * - Setup a window for 30 secs to capture the list of files emited.
		 * - Group by file name as key and ReadableFile as a value.
		 * 2) Output each readable file for content processing.
		 * 3) Split file contents based on batch size for parallel processing.
		 * 4) Process each split as a DLP table content request to invoke API.
		 * 5) Convert DLP Table Rows to BQ Table Row.
		 * 6) Create dynamic table and insert successfully converted records into BQ.
		 */

		PCollection<KV<String, Iterable<ReadableFile>>> csvFiles = p
				/*
				 * 1) Read from the text source continuously based on default interval e.g. 300
				 * seconds
				 * - Setup a window for 30 secs to capture the list of files emited.
				 * - Group by file name as key and ReadableFile as a value.
				 */
				.apply(
						"Poll Input Files",
						FileIO.match()
								.filepattern(options.getInputFilePattern()))
				.apply("Find Pattern Match", FileIO.readMatches().withCompression(Compression.GZIP))
				.apply("Add File Name as Key", WithKeys.of(file -> getFileName(file)))
				.setCoder(KvCoder.of(StringUtf8Coder.of(), ReadableFileCoder.of()))
				.apply(GroupByKey.create());

		PCollection<TableRow> bqDataMap = csvFiles
				// 2) Output each readable file for content processing.
				.apply(
						"File Handler",
						ParDo.of(
								new DoFn<KV<String, Iterable<ReadableFile>>, KV<String, ReadableFile>>() {
									@ProcessElement
									public void processElement(ProcessContext c) {
										String fileKey = c.element().getKey();
										c.element()
												.getValue()
												.forEach(
														file -> {
															c.output(KV.of(fileKey, file));
														});
									}
								}))

				// 3) Split file contents based on batch size for parallel processing.
				.apply(
						"Process File Contents",
						ParDo.of(
								new CSVReader(
										NestedValueProvider.of(
												options.getBatchSize(),
												batchSize -> {
													if (batchSize != null) {
														return batchSize;
													} else {
														return DEFAULT_BATCH_SIZE;
													}
												}))))

				// 4) Create a DLP Table content request and invoke DLP API for each processsing
				.apply(
						"DLP-Tokenization",
						ParDo.of(
								new DLPTokenizationDoFn(
										options.getDlpProjectId(),
										options.getDeidentifyTemplateName(),
										options.getInspectTemplateName())))

				// 5) Convert DLP Table Rows to BQ Table Row
				.apply("Process Tokenized Data", ParDo.of(new TableRowProcessorDoFn()));

		// 6) Create table and insert successfully converted records into BQ.
		bqDataMap.apply(
				"Insert into Bigquery",
				BigQueryIO.writeTableRows()
						.withSchema(
								NestedValueProvider.of(
										options.getJSONPath(),
										new SerializableFunction<String, TableSchema>() {

											@Override
											public TableSchema apply(String jsonPath) {

												TableSchema tableSchema = new TableSchema();
												List<TableFieldSchema> fields = new ArrayList<>();
												SchemaParser schemaParser = new SchemaParser();
												JSONObject jsonSchema;

												try {

													jsonSchema = schemaParser.parseSchema(jsonPath);

													JSONArray bqSchemaJsonArray = jsonSchema
															.getJSONArray(BIGQUERY_SCHEMA);

													for (int i = 0; i < bqSchemaJsonArray.length(); i++) {
														JSONObject inputField = bqSchemaJsonArray.getJSONObject(i);
														TableFieldSchema field = new TableFieldSchema()
																.setName(inputField.getString(NAME))
																.setType(inputField.getString(TYPE));

														if (inputField.has(MODE)) {
															field.setMode(inputField.getString(MODE));
														}

														fields.add(field);
													}
													tableSchema.setFields(fields);

												} catch (Exception e) {
													throw new RuntimeException(e);
												}
												return tableSchema;
											}
										}))
						.to(options.getOutputTable())
						.withCreateDisposition(BigQueryIO.Write.CreateDisposition.CREATE_IF_NEEDED)
						.withWriteDisposition(BigQueryIO.Write.WriteDisposition.WRITE_APPEND)
						.withCustomGcsTempLocation(options.getBigQueryLoadingTemporaryDirectory()));

		return p.run();
	}

	/**
	 * The {@link TokenizePipelineOptions} interface provides the custom execution
	 * options passed by
	 * the executor at the command-line.
	 */
	public interface TokenizePipelineOptions extends DataflowPipelineOptions {

		@TemplateParameter.Text(order = 1, description = "Input Cloud Storage File(s)", helpText = "The Cloud Storage location of the files you'd like to process.", example = "gs://your-bucket/your-files/*.csv.gz")
		ValueProvider<String> getInputFilePattern();

		void setInputFilePattern(ValueProvider<String> value);

		@TemplateParameter.Text(order = 2, regexes = {
				"^projects\\/[^\\n\\r\\/]+(\\/locations\\/[^\\n\\r\\/]+)?\\/deidentifyTemplates\\/[^\\n\\r\\/]+$"
		}, description = "Cloud DLP deidentify template name", helpText = "Cloud DLP template to deidentify contents. Must be created here: https://console.cloud.google.com/security/dlp/create/template.", example = "projects/your-project-id/locations/global/deidentifyTemplates/generated_template_id")
		@Required
		ValueProvider<String> getDeidentifyTemplateName();

		void setDeidentifyTemplateName(ValueProvider<String> value);

		@TemplateParameter.Text(order = 3, optional = true, regexes = {
				"^projects\\/[^\\n\\r\\/]+(\\/locations\\/[^\\n\\r\\/]+)?\\/inspectTemplates\\/[^\\n\\r\\/]+$"
		}, description = "Cloud DLP inspect template name", helpText = "Cloud DLP template to inspect contents.", example = "projects/your-project-id/locations/global/inspectTemplates/generated_template_id")
		ValueProvider<String> getInspectTemplateName();

		void setInspectTemplateName(ValueProvider<String> value);

		@TemplateParameter.Integer(order = 4, optional = true, description = "Batch size", helpText = "Batch size contents (number of rows) to optimize DLP API call. Total size of the "
				+ "rows must not exceed 512 KB and total cell count must not exceed 50,000. Default batch "
				+ "size is set to 100. Ex. 1000")
		@Required
		ValueProvider<Integer> getBatchSize();

		void setBatchSize(ValueProvider<Integer> value);

		@TemplateParameter.ProjectId(order = 5, description = "Cloud DLP project ID", helpText = "Cloud DLP project ID to be used for data masking/tokenization. Ex. your-dlp-project")
		ValueProvider<String> getDlpProjectId();

		void setDlpProjectId(ValueProvider<String> value);

		@TemplateParameter.BigQueryTable(order = 6, description = "BigQuery output table", helpText = "BigQuery table location to write the output to. The table's schema must match the "
				+ "input objects.")
		ValueProvider<String> getOutputTable();

		void setOutputTable(ValueProvider<String> value);

		@TemplateParameter.GcsWriteFolder(order = 7, description = "Temporary directory for BigQuery loading process", helpText = "Temporary directory for BigQuery loading process", example = "gs://your-bucket/your-files/temp_dir")
		@Required
		ValueProvider<String> getBigQueryLoadingTemporaryDirectory();

		void setBigQueryLoadingTemporaryDirectory(ValueProvider<String> directory);

		@TemplateParameter.GcsReadFile(order = 8, description = "Cloud Storage location of your BigQuery schema file, described as a JSON", helpText = "JSON file with BigQuery Schema description. JSON Example: {\n"
				+ "\t\"BigQuery Schema\": [\n"
				+ "\t\t{\n"
				+ "\t\t\t\"name\": \"location\",\n"
				+ "\t\t\t\"type\": \"STRING\"\n"
				+ "\t\t},\n"
				+ "\t\t{\n"
				+ "\t\t\t\"name\": \"name\",\n"
				+ "\t\t\t\"type\": \"STRING\"\n"
				+ "\t\t},\n"
				+ "\t\t{\n"
				+ "\t\t\t\"name\": \"age\",\n"
				+ "\t\t\t\"type\": \"STRING\"\n"
				+ "\t\t},\n"
				+ "\t\t{\n"
				+ "\t\t\t\"name\": \"color\",\n"
				+ "\t\t\t\"type\": \"STRING\"\n"
				+ "\t\t},\n"
				+ "\t\t{\n"
				+ "\t\t\t\"name\": \"coffee\",\n"
				+ "\t\t\t\"type\": \"STRING\"\n"
				+ "\t\t}\n"
				+ "\t]\n"
				+ "}")
		ValueProvider<String> getJSONPath();

		void setJSONPath(ValueProvider<String> value);

		// @TemplateParameter.LauncherMachineType(
		// order = 9,
		// description = "",
		// helpText = "",
		// example = "")
		// ValueProvider<String> getLauncherMachineType();
		//
		// void setLauncherMachineType(ValueProvider<String> value);
		//
		// @TemplateParameter.MachineType(
		// order = 9,
		// description = "",
		// helpText = "",
		// example = "")
		// ValueProvider<String> getMachineType();
		//
		// void setMachineType(ValueProvider<String> value);
		//
		// @TemplateParameter.WorkerMachineType(
		// order = 9,
		// description = "",
		// helpText = "",
		// example = "")
		// String getWorkerMachineType();
		//
		// void setWorkerMachineType(String value);

		@TemplateParameter.NumberOfWorkerHarnessThreads(order = 9, description = "", helpText = "", example = "")
		int getNumberOfWorkerHarnessThreads();

		void setNumberOfWorkerHarnessThreads(int value);

		@TemplateParameter.DirectNumWorkers(order = 9, description = "", helpText = "", example = "")
		int getDirectNumWorkers();

		void setDirectNumWorkers(int value);

		@TemplateParameter.DataflowServiceOptions(order = 9, description = "", helpText = "", example = "")
		List<String> getDataflowServiceOptions();

		void setDataflowServiceOptions(List<String> value);

		@TemplateParameter.Experiments(order = 9, description = "", helpText = "", example = "")
		List<String> getExperiments();

		void setExperiments(List<String> value);
	}

	/**
	 * The {@link CSVReader} class uses experimental Split DoFn to split each csv
	 * file contents in
	 * chunks and process it in non-monolithic fashion. For example: if a CSV file
	 * has 100 rows and
	 * batch size is set to 15, then initial restrictions for the SDF will be 1 to 7
	 * and split
	 * restriction will be {{1-2},{2-3}..{7-8}} for parallel executions.
	 */
	static class CSVReader extends DoFn<KV<String, ReadableFile>, KV<String, Table>> {

		private ValueProvider<Integer> batchSize;
		private PCollectionView<List<KV<String, List<String>>>> headerMap;
		/**
		 * This counter is used to track number of lines processed against batch size.
		 */
		private Integer lineCount;

		public CSVReader(ValueProvider<Integer> batchSize) {
			lineCount = 1;
			this.batchSize = batchSize;
		}

		@ProcessElement
		public void processElement(ProcessContext c, RestrictionTracker<OffsetRange, Long> tracker)
				throws IOException {
			for (long i = tracker.currentRestriction().getFrom(); tracker.tryClaim(i); ++i) {
				String fileKey = c.element().getKey();
				try (BufferedReader br = getReader(c.element().getValue())) {
					List<Table.Row> rows = new ArrayList<>();
					Table dlpTable = null;
					/** finding out EOL for this restriction so that we know the SOL */
					int endOfLine = (int) (i * batchSize.get().intValue());
					int startOfLine = (endOfLine - batchSize.get().intValue());

					// getting the DLP table headers
					Iterator<CSVRecord> csvRows = CSVFormat.DEFAULT.parse(br).iterator();
					if (!csvRows.hasNext()) {
						LOG.info("File `" + c.element().getKey() + "` is empty");
						continue;
					}
					List<FieldId> dlpTableHeaders = toDlpTableHeaders(csvRows.next());

					/** skipping all the rows that's not part of this restriction */
					for (int line = 0; line < startOfLine; line++) {
						if (csvRows.hasNext()) {
							csvRows.next();
						}
					}
					/**
					 * looping through buffered reader and creating DLP Table Rows equals to batch
					 */
					while (csvRows.hasNext() && lineCount <= batchSize.get()) {
						CSVRecord csvRow = csvRows.next();
						rows.add(convertCsvRowToTableRow(csvRow));
						lineCount += 1;
					}
					lineCount = 1;
					/** creating DLP table and output for next transformation */
					dlpTable = Table.newBuilder().addAllHeaders(dlpTableHeaders).addAllRows(rows).build();
					c.output(KV.of(fileKey, dlpTable));

					String template = "Current Restriction From: %s, Current Restriction To: %d StartofLine: %d, End Of Line %d, BatchData %d";
					String message = String.format(template, tracker.currentRestriction().getFrom(),
							tracker.currentRestriction().getTo(), startOfLine,
							endOfLine, dlpTable.getRowsCount());

					LOG.debug(
							"Current Restriction From: {}, Current Restriction To: {},"
									+ " StartofLine: {}, End Of Line {}, BatchData {}",
							tracker.currentRestriction().getFrom(),
							tracker.currentRestriction().getTo(),
							startOfLine,
							endOfLine,
							dlpTable.getRowsCount());
				}
			}
		}

		private static List<FieldId> toDlpTableHeaders(CSVRecord headerRow) {
			List<FieldId> result = new ArrayList<>();
			for (String header : headerRow) {
				result.add(FieldId.newBuilder().setName(header).build());
			}
			return result;
		}

		/**
		 * SDF needs to define a @GetInitialRestriction method that can create a
		 * restriction describing
		 * the complete work for a given element. For our case this would be the total
		 * number of rows
		 * for each CSV file. We will calculate the number of split required based on
		 * total number of
		 * rows and batch size provided.
		 *
		 * @throws IOException
		 */
		@GetInitialRestriction
		public OffsetRange getInitialRestriction(@Element KV<String, ReadableFile> csvFile)
				throws IOException {

			int rowCount = 0;
			int totalSplit = 0;
			try (BufferedReader br = getReader(csvFile.getValue())) {
				/** assume first row is header */
				int checkRowCount = (int) br.lines().count() - 1;
				rowCount = (checkRowCount < 1) ? 1 : checkRowCount;
				totalSplit = rowCount / batchSize.get().intValue();
				int remaining = rowCount % batchSize.get().intValue();
				/**
				 * Adjusting the total number of split based on remaining rows. For example:
				 * batch size of
				 * 15 for 100 rows will have total 7 splits. As it's a range last split will
				 * have offset
				 * range {7,8}
				 */
				if (remaining > 0) {
					totalSplit = totalSplit + 2;

				} else {
					totalSplit = totalSplit + 1;
				}
			}

			LOG.debug("Initial Restriction range from 1 to: {}", totalSplit);
			return new OffsetRange(1, totalSplit);
		}

		/**
		 * SDF needs to define a @SplitRestriction method that can split the intital
		 * restricton to a
		 * number of smaller restrictions. For example: a intital rewstriction of (x, N)
		 * as input and
		 * produces pairs (x, 0), (x, 1), …, (x, N-1) as output.
		 */
		@SplitRestriction
		public void splitRestriction(
				@Element KV<String, ReadableFile> csvFile,
				@Restriction OffsetRange range,
				OutputReceiver<OffsetRange> out) {
			/** split the initial restriction by 1 */
			for (final OffsetRange p : range.split(1, 1)) {
				out.output(p);
			}
		}

		@NewTracker
		public OffsetRangeTracker newTracker(@Restriction OffsetRange range) {
			return new OffsetRangeTracker(new OffsetRange(range.getFrom(), range.getTo()));
		}

		private Table.Row convertCsvRowToTableRow(CSVRecord csvRow) {
			/** convert from CSV row to DLP Table Row */
			Iterator<String> valueIterator = csvRow.iterator();
			Table.Row.Builder tableRowBuilder = Table.Row.newBuilder();
			while (valueIterator.hasNext()) {
				String value = valueIterator.next();
				tableRowBuilder.addValues(Value.newBuilder().setStringValue(value.toString()).build());
				// if (value != null) {
				// tableRowBuilder.addValues(Value.newBuilder().setStringValue(value.toString()).build());
				// } else {
				// tableRowBuilder.addValues(Value.newBuilder().setStringValue("").build());
				// }
			}

			return tableRowBuilder.build();
		}

		private List<String> getHeaders(List<KV<String, List<String>>> headerMap, String fileKey) {
			return headerMap.stream()
					.filter(map -> map.getKey().equalsIgnoreCase(fileKey))
					.findFirst()
					.map(e -> e.getValue())
					.orElse(null);
		}
	}

	/**
	 * The {@link DLPTokenizationDoFn} class executes tokenization request by
	 * calling DLP api. It uses
	 * DLP table as a content item as CSV file contains fully structured data. DLP
	 * templates (e.g.
	 * de-identify, inspect) need to exist before this pipeline runs. As response
	 * from the API is
	 * received, this DoFn ouptputs KV of new table with table id as key.
	 */
	static class DLPTokenizationDoFn extends DoFn<KV<String, Table>, KV<String, Table>> {
		private ValueProvider<String> dlpProjectId;
		private DlpServiceClient dlpServiceClient;
		private ValueProvider<String> deIdentifyTemplateName;
		private ValueProvider<String> inspectTemplateName;
		private boolean inspectTemplateExist;
		private Builder requestBuilder;
		private final Distribution numberOfRowsTokenized = Metrics.distribution(DLPTokenizationDoFn.class,
				"numberOfRowsTokenizedDistro");
		private final Distribution numberOfBytesTokenized = Metrics.distribution(DLPTokenizationDoFn.class,
				"numberOfBytesTokenizedDistro");

		public DLPTokenizationDoFn(
				ValueProvider<String> dlpProjectId,
				ValueProvider<String> deIdentifyTemplateName,
				ValueProvider<String> inspectTemplateName) {
			this.dlpProjectId = dlpProjectId;
			this.dlpServiceClient = null;
			this.deIdentifyTemplateName = deIdentifyTemplateName;
			this.inspectTemplateName = inspectTemplateName;
			this.inspectTemplateExist = false;
		}

		@Setup
		public void setup() {
			if (this.inspectTemplateName.isAccessible()) {
				if (this.inspectTemplateName.get() != null) {
					this.inspectTemplateExist = true;
				}
			}
			if (this.deIdentifyTemplateName.isAccessible()) {
				if (this.deIdentifyTemplateName.get() != null) {
					this.requestBuilder = DeidentifyContentRequest.newBuilder()
							.setParent(ProjectName.of(this.dlpProjectId.get()).toString())
							.setDeidentifyTemplateName(this.deIdentifyTemplateName.get());
					if (this.inspectTemplateExist) {
						this.requestBuilder.setInspectTemplateName(this.inspectTemplateName.get());
					}
				}
			}
		}

		@StartBundle
		public void startBundle() throws SQLException {

			try {
				this.dlpServiceClient = DlpServiceClient.create();

			} catch (IOException e) {
				LOG.error("Failed to create DLP Service Client", e.getMessage());
				throw new RuntimeException(e);
			}
		}

		@FinishBundle
		public void finishBundle() throws Exception {
			if (this.dlpServiceClient != null) {
				this.dlpServiceClient.close();
			}
		}

		@ProcessElement
		public void processElement(ProcessContext c) {
			String key = c.element().getKey();
			Table nonEncryptedData = c.element().getValue();
			ContentItem tableItem = ContentItem.newBuilder().setTable(nonEncryptedData).build();
			this.requestBuilder.setItem(tableItem);
			DeidentifyContentResponse response = dlpServiceClient.deidentifyContent(this.requestBuilder.build());
			Table tokenizedData = response.getItem().getTable();
			numberOfRowsTokenized.update(tokenizedData.getRowsList().size());
			numberOfBytesTokenized.update(tokenizedData.toByteArray().length);
			c.output(KV.of(key, tokenizedData));
		}
	}

	/**
	 * The {@link TableRowProcessorDoFn} class process tokenized DLP tables and
	 * convert them to
	 * BigQuery Table Row.
	 */
	public static class TableRowProcessorDoFn extends DoFn<KV<String, Table>, TableRow> {

		@ProcessElement
		public void processElement(ProcessContext c) {

			Table tokenizedData = c.element().getValue();
			List<String> headers = tokenizedData.getHeadersList().stream()
					.map(fid -> fid.getName())
					.collect(Collectors.toList());
			List<Table.Row> outputRows = tokenizedData.getRowsList();
			if (outputRows.size() > 0) {
				for (Table.Row outputRow : outputRows) {
					if (outputRow.getValuesCount() != headers.size()) {
						throw new IllegalArgumentException(
								"CSV file's header count must exactly match with data element count");
					}
					c.output(
							createBqRow(outputRow, headers.toArray(new String[headers.size()])));
				}
			}
		}

		private static TableRow createBqRow(Table.Row tokenizedValue, String[] headers) {
			TableRow bqRow = new TableRow();
			AtomicInteger headerIndex = new AtomicInteger(0);
			List<TableCell> cells = new ArrayList<>();
			tokenizedValue
					.getValuesList()
					.forEach(
							value -> {
								String checkedHeaderName = checkHeaderName(
										headers[headerIndex.getAndIncrement()].toString());
								bqRow.set(checkedHeaderName, value.getStringValue());
								cells.add(new TableCell().set(checkedHeaderName, value.getStringValue()));
							});
			// bqRow.setF(cells);
			return bqRow;
		}
	}

	private static String getFileName(ReadableFile file) {
		String csvFileName = file.getMetadata().resourceId().getFilename().toString();
		/** taking out .csv extension from file name e.g fileName.csv->fileName */
		String[] fileKey = csvFileName.split("\\.", 2);

		if (!fileKey[1].equals(ALLOWED_FILE_EXTENSION) || !TABLE_REGEXP.matcher(fileKey[0]).matches()) {
			throw new RuntimeException(
					"[Filename must contain a CSV extension "
							+ " BQ table name must contain only letters, numbers, or underscores ["
							+ fileKey[1]
							+ "], ["
							+ fileKey[0]
							+ "]");
		}
		/** returning file name without extension */
		return fileKey[0];
	}

	private static BufferedReader getReader(ReadableFile csvFile) {
		BufferedReader br = null;
		ReadableByteChannel channel = null;
		/** read the file and create buffered reader */
		try {
			// channel = csvFile.openSeekable();
			channel = csvFile.getCompression().readDecompressed(FileSystems.open(csvFile.getMetadata().resourceId()));
			if (channel != null) {
				// br = new BufferedReader(Channels.newReader(channel, Charsets.UTF_8.name()));
				br = new BufferedReader(new InputStreamReader(Channels.newInputStream(channel)));
			}
			return br;
		} catch (IOException e) {
			LOG.error("Failed to Read File {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}

	private static String checkHeaderName(String name) {
		/**
		 * some checks to make sure BQ column names don't fail e.g. special characters
		 */
		String checkedHeader = name.replaceAll("\\s", "_");
		checkedHeader = checkedHeader.replaceAll("'", "");
		checkedHeader = checkedHeader.replaceAll("/", "");
		if (!COLUMN_NAME_REGEXP.matcher(checkedHeader).matches()) {
			throw new IllegalArgumentException("Column name can't be matched to a valid format " + name);
		}
		return checkedHeader;
	}
}
