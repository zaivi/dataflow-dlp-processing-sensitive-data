package com.google.cloud.syndeo.transforms.bigtable;

import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_BigTableWriteSchemaTransformConfiguration extends BigTableWriteSchemaTransformConfiguration {

  private final String projectId;

  private final String instanceId;

  private final String tableId;

  private final List<String> keyColumns;

  private final String endpoint;

  private final String appProfileId;

  private AutoValue_BigTableWriteSchemaTransformConfiguration(
      String projectId,
      String instanceId,
      String tableId,
      List<String> keyColumns,
      @Nullable String endpoint,
      @Nullable String appProfileId) {
    this.projectId = projectId;
    this.instanceId = instanceId;
    this.tableId = tableId;
    this.keyColumns = keyColumns;
    this.endpoint = endpoint;
    this.appProfileId = appProfileId;
  }

  @Override
  public String getProjectId() {
    return projectId;
  }

  @Override
  public String getInstanceId() {
    return instanceId;
  }

  @Override
  public String getTableId() {
    return tableId;
  }

  @Override
  public List<String> getKeyColumns() {
    return keyColumns;
  }

  @Nullable
  @Override
  public String getEndpoint() {
    return endpoint;
  }

  @Nullable
  @Override
  public String getAppProfileId() {
    return appProfileId;
  }

  @Override
  public String toString() {
    return "BigTableWriteSchemaTransformConfiguration{"
        + "projectId=" + projectId + ", "
        + "instanceId=" + instanceId + ", "
        + "tableId=" + tableId + ", "
        + "keyColumns=" + keyColumns + ", "
        + "endpoint=" + endpoint + ", "
        + "appProfileId=" + appProfileId
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BigTableWriteSchemaTransformConfiguration) {
      BigTableWriteSchemaTransformConfiguration that = (BigTableWriteSchemaTransformConfiguration) o;
      return this.projectId.equals(that.getProjectId())
          && this.instanceId.equals(that.getInstanceId())
          && this.tableId.equals(that.getTableId())
          && this.keyColumns.equals(that.getKeyColumns())
          && (this.endpoint == null ? that.getEndpoint() == null : this.endpoint.equals(that.getEndpoint()))
          && (this.appProfileId == null ? that.getAppProfileId() == null : this.appProfileId.equals(that.getAppProfileId()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= projectId.hashCode();
    h$ *= 1000003;
    h$ ^= instanceId.hashCode();
    h$ *= 1000003;
    h$ ^= tableId.hashCode();
    h$ *= 1000003;
    h$ ^= keyColumns.hashCode();
    h$ *= 1000003;
    h$ ^= (endpoint == null) ? 0 : endpoint.hashCode();
    h$ *= 1000003;
    h$ ^= (appProfileId == null) ? 0 : appProfileId.hashCode();
    return h$;
  }

  static final class Builder extends BigTableWriteSchemaTransformConfiguration.Builder {
    private String projectId;
    private String instanceId;
    private String tableId;
    private List<String> keyColumns;
    private String endpoint;
    private String appProfileId;
    Builder() {
    }
    @Override
    public BigTableWriteSchemaTransformConfiguration.Builder setProjectId(String projectId) {
      if (projectId == null) {
        throw new NullPointerException("Null projectId");
      }
      this.projectId = projectId;
      return this;
    }
    @Override
    public BigTableWriteSchemaTransformConfiguration.Builder setInstanceId(String instanceId) {
      if (instanceId == null) {
        throw new NullPointerException("Null instanceId");
      }
      this.instanceId = instanceId;
      return this;
    }
    @Override
    public BigTableWriteSchemaTransformConfiguration.Builder setTableId(String tableId) {
      if (tableId == null) {
        throw new NullPointerException("Null tableId");
      }
      this.tableId = tableId;
      return this;
    }
    @Override
    public BigTableWriteSchemaTransformConfiguration.Builder setKeyColumns(List<String> keyColumns) {
      if (keyColumns == null) {
        throw new NullPointerException("Null keyColumns");
      }
      this.keyColumns = keyColumns;
      return this;
    }
    @Override
    public BigTableWriteSchemaTransformConfiguration.Builder setEndpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }
    @Override
    public BigTableWriteSchemaTransformConfiguration.Builder setAppProfileId(String appProfileId) {
      this.appProfileId = appProfileId;
      return this;
    }
    @Override
    public BigTableWriteSchemaTransformConfiguration build() {
      if (this.projectId == null
          || this.instanceId == null
          || this.tableId == null
          || this.keyColumns == null) {
        StringBuilder missing = new StringBuilder();
        if (this.projectId == null) {
          missing.append(" projectId");
        }
        if (this.instanceId == null) {
          missing.append(" instanceId");
        }
        if (this.tableId == null) {
          missing.append(" tableId");
        }
        if (this.keyColumns == null) {
          missing.append(" keyColumns");
        }
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_BigTableWriteSchemaTransformConfiguration(
          this.projectId,
          this.instanceId,
          this.tableId,
          this.keyColumns,
          this.endpoint,
          this.appProfileId);
    }
  }

}
