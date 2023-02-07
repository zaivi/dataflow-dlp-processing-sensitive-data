/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.teleport.templates.custom;

import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.api.services.bigquery.model.TableRow;
import com.google.api.services.bigquery.model.TableSchema;

import com.google.cloud.teleport.metadata.Template;
import com.google.cloud.teleport.metadata.TemplateCategory;
import com.google.cloud.teleport.metadata.TemplateParameter;
import com.google.cloud.teleport.templates.common.SchemaParser;
import com.google.cloud.teleport.templates.common.*;
import com.google.cloud.teleport.templates.custom.DLPReidentifyBigQueryToBigQueryBatch.TokenizePipelineOptions;

import com.google.privacy.dlp.v2.LocationName;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.PipelineResult;
import org.apache.beam.sdk.io.gcp.bigquery.BigQueryIO;
import org.apache.beam.sdk.options.*;
import org.apache.beam.sdk.options.Validation.Required;
import org.apache.beam.sdk.options.ValueProvider.NestedValueProvider;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionView;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Template(name = "Batch_DLP_BigQuery_to_BigQuery_Reidentify", category = TemplateCategory.BATCH, displayName = "Re-identify pipeline from BigQuery to BigQuery (using Cloud DLP)", description = "Re-identify pipeline from BigQuery to BigQuery (using Cloud DLP)", optionsClass = TokenizePipelineOptions.class, contactInformation = "https://cloud.google.com/support")
public class DLPReidentifyBigQueryToBigQueryBatch {
	public static final Logger LOG = LoggerFactory.getLogger(DLPReidentifyBigQueryToBigQueryBatch.class);

	private static final String BIGQUERY_SCHEMA = "BigQuery Schema";
	private static final String NAME = "name";
	private static final String TYPE = "type";
	private static final String MODE = "mode";

	public static void main(String[] args) {
		// Example parameters
		String[] pipelineOptions = {
				"--experiments=use_runner_v2",
				 "--runner=DataflowRunner",
				"--project=ext-pinetree",
				"--region=asia-southeast1",
				// "--datasetName=test_giai",
				"--subnetwork=https://www.googleapis.com/compute/v1/projects/ext-pinetree/regions/asia-southeast1/subnetworks/poc-subnet",

				"--numWorkers=1",
				"--maxNumWorkers=2",
				"--numberOfWorkerHarnessThreads=12",
				"--workerMachineType=n2-standard-8",
				// "--dlpProjectId=ext-pinetree",

				"--batchSize=500",
				"--deidentifyTemplateName=projects/ext-pinetree/locations/global/deidentifyTemplates/2073298865825635522",
				"--keyRange=1024",
				"--readQuery=SELECT * FROM `ext-pinetree.test_giai.TCA_HOLIDAY`",
				"--tableRef=ext-pinetree:test_giai.TCA_HOLIDAY",
				"--tempLocation=gs://dataflow-staging-asia-southeast1-326091207235/tmp",

				"--JSONPath=gs://ext-pinetree-re-identify-test/bigquery/schemas/TCA_HOLIDAY.json",
				"--outputTable=ext-pinetree:test_giai.TCA_HOLIDAY_re_identify",

				"--bigQueryLoadingTemporaryDirectory=gs://ext-pinetree-re-identify-test/bigquery/temp_dir"
		};

		TokenizePipelineOptions options = PipelineOptionsFactory.fromArgs(args)
				.as(TokenizePipelineOptions.class);
		run(options);
	}

	public static PipelineResult run(TokenizePipelineOptions options) {
		Pipeline p = Pipeline.create(options);

		// Read DLP from BQ
		PCollection<KV<String, TableRow>> records = p.apply(
				"ReadFromBQ",
				BigQueryReadTransform.newBuilder()
						.setTableRef(options.getTableRef())
						.setKeyRange(options.getKeyRange())
						.setQuery(options.getReadQuery())
						.build());

		PCollectionView<Map<String, List<String>>> selectedColumns = records
				.apply("GetARow", Sample.any(1))
				.apply("GetColumns", ParDo.of(new BigQueryTableHeaderDoFn()))
				.apply("CreateSideInput", View.asMap());

		// Request re-identify API
		PCollection<KV<String, TableRow>> reidData = records
				.apply("ConvertTableRow", ParDo.of(new MergeBigQueryRowToDlpRow()))
				.apply(
						"DLPTransform",
						DLPTransform.newBuilder()
								.setBatchSize(options.getBatchSize())
								// .setInspectTemplateName(options.getInspectTemplateName())
								.setDeidTemplateName(options.getDeidentifyTemplateName())
								.setProjectId(options.getDLPParent())
								.setHeaders(selectedColumns)
								.setColumnDelimiter(options.getColumnDelimiter())
								.setJobName(options.getJobName())
								.build())
				.get(Util.reidSuccess);

		// Format re-identify table row
		PCollection<TableRow> reidDataFormated = reidData
				.apply(
						"Convert type KV to Table Rows",
						ParDo.of(
								new DoFn<KV<String, TableRow>, TableRow>() {
									@ProcessElement
									public void processElement(ProcessContext c) {
										Gson gson = new Gson();
										String outputRow = gson.toJson(c.element().getValue());

										JsonElement outputRowElement = new JsonParser().parse(outputRow);
										JsonObject outputRowObject = outputRowElement.getAsJsonObject();
										outputRowObject.remove("f");

										TableRow bqRow = new TableRow();
										for (Map.Entry<String, JsonElement> entry : outputRowObject.entrySet()) {
											bqRow.set(entry.getKey(), entry.getValue().getAsString());
										}

										// LOG.info("Table value {}", bqRow);
										c.output(bqRow);
									}
								}));

		// BQ write to destination
		reidDataFormated
				.apply(
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
																JSONObject inputField = bqSchemaJsonArray
																		.getJSONObject(i);
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

	public interface TokenizePipelineOptions extends DataflowPipelineOptions {
		@TemplateParameter.Text(order = 1, regexes = {
				"^projects\\/[^\\n\\r\\/]+(\\/locations\\/[^\\n\\r\\/]+)?\\/deidentifyTemplates\\/[^\\n\\r\\/]+$"
		}, description = "Cloud DLP deidentify template name", helpText = "Cloud DLP template to deidentify contents. Must be created here: https://console.cloud.google.com/security/dlp/create/template.", example = "projects/your-project-id/locations/global/deidentifyTemplates/generated_template_id")
		@Required
		ValueProvider<String> getDeidentifyTemplateName();

		void setDeidentifyTemplateName(ValueProvider<String> value);

		@TemplateParameter.Text(order = 2, optional = true, regexes = {
				"^projects\\/[^\\n\\r\\/]+(\\/locations\\/[^\\n\\r\\/]+)?\\/inspectTemplates\\/[^\\n\\r\\/]+$"
		}, description = "Cloud DLP inspect template name", helpText = "Cloud DLP template to inspect contents.", example = "projects/your-project-id/locations/global/inspectTemplates/generated_template_id")
		ValueProvider<String> getInspectTemplateName();

		void setInspectTemplateName(ValueProvider<String> value);

		@TemplateParameter.Integer(order = 9, optional = true, description = "Batch size", helpText = "Batch size contents (number of rows) to optimize DLP API call. Total size of the "
				+ "rows must not exceed 512 KB and total cell count must not exceed 50,000. Default batch "
				+ "size is set to 100. Ex. 1000")
		@Required
		ValueProvider<Integer> getBatchSize();

		void setBatchSize(ValueProvider<Integer> value);

		// @TemplateParameter.ProjectId(
		// order = 5,
		// description = "Cloud DLP project ID",
		// helpText =
		// "Cloud DLP project ID to be used for data masking/tokenization. Ex.
		// your-dlp-project")
		// ValueProvider<String> getDlpProjectId();
		//
		// void setDlpProjectId(ValueProvider<String> value);projectid

		@TemplateParameter.BigQueryTable(order = 4, description = "BigQuery output table", helpText = "BigQuery table location to write the output to. The table's schema must match the "
				+ "input objects.")
		ValueProvider<String> getOutputTable();

		void setOutputTable(ValueProvider<String> value);

		@TemplateParameter.BigQueryTable(order = 3, description = "BigQuery export table", helpText = "BigQuery table to export from in the form <project>:<dataset>.<table>")
		ValueProvider<String> getTableRef();

		void setTableRef(ValueProvider<String> value);

		// @TemplateParameter.Enum(
		// order = 6,
		// description = "BigQuery read method",
		// helpText =
		// "read method default, direct, export")
		// // @Default.Enum("EXPORT")
		// ValueProvider<Method> getReadMethod();

		// void setReadMethod(ValueProvider<Method> method);

		@TemplateParameter.Integer(order = 9, description = "Key range", helpText = "Key range")
		ValueProvider<Integer> getKeyRange();

		void setKeyRange(ValueProvider<Integer> value);

		@TemplateParameter.Text(order = 5, description = "Input SQL query", helpText = "SQL query in standard SQL to pull data from BigQuery")
		ValueProvider<String> getReadQuery();

		void setReadQuery(ValueProvider<String> value);

		@TemplateParameter.Text(order = 6, description = "Column delimiter", helpText = "ColumnDelimiter")
		ValueProvider<Character> getColumnDelimiter();

		void setColumnDelimiter(ValueProvider<Character> value);

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

		@TemplateParameter.NumberOfWorkerHarnessThreads(order = 10, description = "", helpText = "", example = "")
		int getNumberOfWorkerHarnessThreads();

		void setNumberOfWorkerHarnessThreads(int value);

		@TemplateParameter.DataflowServiceOptions(order = 11, description = "", helpText = "", example = "")
		List<String> getDataflowServiceOptions();

		void setDataflowServiceOptions(List<String> value);

		@TemplateParameter.Experiments(order = 12, description = "", helpText = "", example = "")
		List<String> getExperiments();

		void setExperiments(List<String> value);

		class DLPConfigProjectFactory implements DefaultValueFactory<String> {
			@Override
			public String create(PipelineOptions options) {
				return LocationName.of(
						((TokenizePipelineOptions) options).getProject(), "global")
						.toString();
			}
		}

		@Default.InstanceFactory(DLPConfigProjectFactory.class)
		String getDLPParent();

		void setDLPParent(String parent);
	}
}
