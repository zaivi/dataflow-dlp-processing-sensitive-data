mvn package -PtemplatesStage  \
  -DskipTests \
  -DprojectId="ext-pinetree" \
  -DbucketName="dataflow-dlp/templates" \
  -DstagePrefix="staging" \
  -DtemplateName="Batch_DLP_GCS_to_BigQuery_Deidentify" \
  -pl v1 -am

# mvn package -PtemplatesStage  \
#   -DskipTests \
#   -DprojectId="ext-pinetree" \
#   -DbucketName="ext-pinetree-re-identify-test/templates" \
#   -DstagePrefix="staging" \
#   -DtemplateName="Batch_DLP_BigQuery_to_BigQuery_Reidentify" \
#   -pl v1 -am