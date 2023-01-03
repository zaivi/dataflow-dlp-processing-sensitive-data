gcloud dataflow flex-template build gs://dataflow-dlp/templates/batching-beam-dlp.json \
    --image-gcr-path "" \
    --sdk-language "JAVA" \
    --flex-template-base-image JAVA11 \
    --metadata-file "v1/target/classes/batch-dlp-gcs-text-to-bigquery-generated-metadata.json" \
    --jar "v1/target/classic-templates-1.0-SNAPSHOT.jar" \
    --env FLEX_TEMPLATE_JAVA_MAIN_CLASS="com.google.cloud.teleport.templates.DLPTextToBigQueryBatch"