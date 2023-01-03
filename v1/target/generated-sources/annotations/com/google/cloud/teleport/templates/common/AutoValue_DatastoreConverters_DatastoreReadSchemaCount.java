package com.google.cloud.teleport.templates.common;

import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DatastoreConverters_DatastoreReadSchemaCount extends DatastoreConverters.DatastoreReadSchemaCount {

  private final ValueProvider<String> projectId;

  private final ValueProvider<String> gqlQuery;

  private final ValueProvider<String> namespace;

  private AutoValue_DatastoreConverters_DatastoreReadSchemaCount(
      ValueProvider<String> projectId,
      ValueProvider<String> gqlQuery,
      ValueProvider<String> namespace) {
    this.projectId = projectId;
    this.gqlQuery = gqlQuery;
    this.namespace = namespace;
  }

  @Override
  public ValueProvider<String> projectId() {
    return projectId;
  }

  @Override
  public ValueProvider<String> gqlQuery() {
    return gqlQuery;
  }

  @Override
  public ValueProvider<String> namespace() {
    return namespace;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DatastoreConverters.DatastoreReadSchemaCount) {
      DatastoreConverters.DatastoreReadSchemaCount that = (DatastoreConverters.DatastoreReadSchemaCount) o;
      return this.projectId.equals(that.projectId())
          && this.gqlQuery.equals(that.gqlQuery())
          && this.namespace.equals(that.namespace());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= projectId.hashCode();
    h$ *= 1000003;
    h$ ^= gqlQuery.hashCode();
    h$ *= 1000003;
    h$ ^= namespace.hashCode();
    return h$;
  }

  static final class Builder extends DatastoreConverters.DatastoreReadSchemaCount.Builder {
    private ValueProvider<String> projectId;
    private ValueProvider<String> gqlQuery;
    private ValueProvider<String> namespace;
    Builder() {
    }
    @Override
    public DatastoreConverters.DatastoreReadSchemaCount.Builder setProjectId(ValueProvider<String> projectId) {
      if (projectId == null) {
        throw new NullPointerException("Null projectId");
      }
      this.projectId = projectId;
      return this;
    }
    @Override
    public DatastoreConverters.DatastoreReadSchemaCount.Builder setGqlQuery(ValueProvider<String> gqlQuery) {
      if (gqlQuery == null) {
        throw new NullPointerException("Null gqlQuery");
      }
      this.gqlQuery = gqlQuery;
      return this;
    }
    @Override
    public DatastoreConverters.DatastoreReadSchemaCount.Builder setNamespace(ValueProvider<String> namespace) {
      if (namespace == null) {
        throw new NullPointerException("Null namespace");
      }
      this.namespace = namespace;
      return this;
    }
    @Override
    public DatastoreConverters.DatastoreReadSchemaCount build() {
      String missing = "";
      if (this.projectId == null) {
        missing += " projectId";
      }
      if (this.gqlQuery == null) {
        missing += " gqlQuery";
      }
      if (this.namespace == null) {
        missing += " namespace";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_DatastoreConverters_DatastoreReadSchemaCount(
          this.projectId,
          this.gqlQuery,
          this.namespace);
    }
  }

}
