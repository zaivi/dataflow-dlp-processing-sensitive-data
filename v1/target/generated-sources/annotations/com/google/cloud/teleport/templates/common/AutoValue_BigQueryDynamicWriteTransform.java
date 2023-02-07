package com.google.cloud.teleport.templates.common;

import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_BigQueryDynamicWriteTransform extends BigQueryDynamicWriteTransform {

  private final String projectId;

  private final String datasetId;

  private AutoValue_BigQueryDynamicWriteTransform(
      String projectId,
      String datasetId) {
    this.projectId = projectId;
    this.datasetId = datasetId;
  }

  @Override
  public String projectId() {
    return projectId;
  }

  @Override
  public String datasetId() {
    return datasetId;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BigQueryDynamicWriteTransform) {
      BigQueryDynamicWriteTransform that = (BigQueryDynamicWriteTransform) o;
      return this.projectId.equals(that.projectId())
          && this.datasetId.equals(that.datasetId());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= projectId.hashCode();
    h$ *= 1000003;
    h$ ^= datasetId.hashCode();
    return h$;
  }

  static final class Builder extends BigQueryDynamicWriteTransform.Builder {
    private String projectId;
    private String datasetId;
    Builder() {
    }
    @Override
    public BigQueryDynamicWriteTransform.Builder setProjectId(String projectId) {
      if (projectId == null) {
        throw new NullPointerException("Null projectId");
      }
      this.projectId = projectId;
      return this;
    }
    @Override
    public BigQueryDynamicWriteTransform.Builder setDatasetId(String datasetId) {
      if (datasetId == null) {
        throw new NullPointerException("Null datasetId");
      }
      this.datasetId = datasetId;
      return this;
    }
    @Override
    public BigQueryDynamicWriteTransform build() {
      String missing = "";
      if (this.projectId == null) {
        missing += " projectId";
      }
      if (this.datasetId == null) {
        missing += " datasetId";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_BigQueryDynamicWriteTransform(
          this.projectId,
          this.datasetId);
    }
  }

}
