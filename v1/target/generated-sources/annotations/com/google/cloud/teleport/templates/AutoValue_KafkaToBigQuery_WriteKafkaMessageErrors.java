package com.google.cloud.teleport.templates;

import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_KafkaToBigQuery_WriteKafkaMessageErrors extends KafkaToBigQuery.WriteKafkaMessageErrors {

  private final ValueProvider<String> errorRecordsTable;

  private final String errorRecordsTableSchema;

  private AutoValue_KafkaToBigQuery_WriteKafkaMessageErrors(
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
    if (o instanceof KafkaToBigQuery.WriteKafkaMessageErrors) {
      KafkaToBigQuery.WriteKafkaMessageErrors that = (KafkaToBigQuery.WriteKafkaMessageErrors) o;
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

  static final class Builder extends KafkaToBigQuery.WriteKafkaMessageErrors.Builder {
    private ValueProvider<String> errorRecordsTable;
    private String errorRecordsTableSchema;
    Builder() {
    }
    @Override
    public KafkaToBigQuery.WriteKafkaMessageErrors.Builder setErrorRecordsTable(ValueProvider<String> errorRecordsTable) {
      if (errorRecordsTable == null) {
        throw new NullPointerException("Null errorRecordsTable");
      }
      this.errorRecordsTable = errorRecordsTable;
      return this;
    }
    @Override
    public KafkaToBigQuery.WriteKafkaMessageErrors.Builder setErrorRecordsTableSchema(String errorRecordsTableSchema) {
      if (errorRecordsTableSchema == null) {
        throw new NullPointerException("Null errorRecordsTableSchema");
      }
      this.errorRecordsTableSchema = errorRecordsTableSchema;
      return this;
    }
    @Override
    public KafkaToBigQuery.WriteKafkaMessageErrors build() {
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
      return new AutoValue_KafkaToBigQuery_WriteKafkaMessageErrors(
          this.errorRecordsTable,
          this.errorRecordsTableSchema);
    }
  }

}
