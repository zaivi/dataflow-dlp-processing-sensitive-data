package com.google.cloud.teleport.templates.common;

import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ErrorConverters_WritePubsubMessageErrors extends ErrorConverters.WritePubsubMessageErrors {

  private final ValueProvider<String> errorRecordsTable;

  private final String errorRecordsTableSchema;

  private AutoValue_ErrorConverters_WritePubsubMessageErrors(
      ValueProvider<String> errorRecordsTable,
      String errorRecordsTableSchema) {
    this.errorRecordsTable = errorRecordsTable;
    this.errorRecordsTableSchema = errorRecordsTableSchema;
  }

  @Override
  public ValueProvider<String> getErrorRecordsTable() {
    return errorRecordsTable;
  }

  @Override
  public String getErrorRecordsTableSchema() {
    return errorRecordsTableSchema;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ErrorConverters.WritePubsubMessageErrors) {
      ErrorConverters.WritePubsubMessageErrors that = (ErrorConverters.WritePubsubMessageErrors) o;
      return this.errorRecordsTable.equals(that.getErrorRecordsTable())
          && this.errorRecordsTableSchema.equals(that.getErrorRecordsTableSchema());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= errorRecordsTable.hashCode();
    h$ *= 1000003;
    h$ ^= errorRecordsTableSchema.hashCode();
    return h$;
  }

  static final class Builder extends ErrorConverters.WritePubsubMessageErrors.Builder {
    private ValueProvider<String> errorRecordsTable;
    private String errorRecordsTableSchema;
    Builder() {
    }
    @Override
    public ErrorConverters.WritePubsubMessageErrors.Builder setErrorRecordsTable(ValueProvider<String> errorRecordsTable) {
      if (errorRecordsTable == null) {
        throw new NullPointerException("Null errorRecordsTable");
      }
      this.errorRecordsTable = errorRecordsTable;
      return this;
    }
    @Override
    public ErrorConverters.WritePubsubMessageErrors.Builder setErrorRecordsTableSchema(String errorRecordsTableSchema) {
      if (errorRecordsTableSchema == null) {
        throw new NullPointerException("Null errorRecordsTableSchema");
      }
      this.errorRecordsTableSchema = errorRecordsTableSchema;
      return this;
    }
    @Override
    public ErrorConverters.WritePubsubMessageErrors build() {
      String missing = "";
      if (this.errorRecordsTable == null) {
        missing += " errorRecordsTable";
      }
      if (this.errorRecordsTableSchema == null) {
        missing += " errorRecordsTableSchema";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_ErrorConverters_WritePubsubMessageErrors(
          this.errorRecordsTable,
          this.errorRecordsTableSchema);
    }
  }

}
