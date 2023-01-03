mvn package -PtemplatesStage  \
  -DskipTests \
  -DprojectId="" \
  -DbucketName="dataflow-dlp/templates" \
  -DstagePrefix="staging" \
  -DtemplateName="Batch_DLP_GCS_Text_to_BigQuery" \
  -pl v1 -am