package com.google.cloud.teleport.templates.common;

import com.google.api.services.bigquery.model.TableRow;
import com.google.cloud.teleport.values.FailsafeElement;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.values.TupleTag;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_BigQueryConverters_FailsafeJsonToTableRow<T> extends BigQueryConverters.FailsafeJsonToTableRow<T> {

  private final TupleTag<TableRow> successTag;

  private final TupleTag<FailsafeElement<T, String>> failureTag;

  private AutoValue_BigQueryConverters_FailsafeJsonToTableRow(
      TupleTag<TableRow> successTag,
      TupleTag<FailsafeElement<T, String>> failureTag) {
    this.successTag = successTag;
    this.failureTag = failureTag;
  }

  @Override
  public TupleTag<TableRow> successTag() {
    return successTag;
  }

  @Override
  public TupleTag<FailsafeElement<T, String>> failureTag() {
    return failureTag;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BigQueryConverters.FailsafeJsonToTableRow) {
      BigQueryConverters.FailsafeJsonToTableRow<?> that = (BigQueryConverters.FailsafeJsonToTableRow<?>) o;
      return this.successTag.equals(that.successTag())
          && this.failureTag.equals(that.failureTag());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= successTag.hashCode();
    h$ *= 1000003;
    h$ ^= failureTag.hashCode();
    return h$;
  }

  static final class Builder<T> extends BigQueryConverters.FailsafeJsonToTableRow.Builder<T> {
    private TupleTag<TableRow> successTag;
    private TupleTag<FailsafeElement<T, String>> failureTag;
    Builder() {
    }
    @Override
    public BigQueryConverters.FailsafeJsonToTableRow.Builder<T> setSuccessTag(TupleTag<TableRow> successTag) {
      if (successTag == null) {
        throw new NullPointerException("Null successTag");
      }
      this.successTag = successTag;
      return this;
    }
    @Override
    public BigQueryConverters.FailsafeJsonToTableRow.Builder<T> setFailureTag(TupleTag<FailsafeElement<T, String>> failureTag) {
      if (failureTag == null) {
        throw new NullPointerException("Null failureTag");
      }
      this.failureTag = failureTag;
      return this;
    }
    @Override
    public BigQueryConverters.FailsafeJsonToTableRow<T> build() {
      String missing = "";
      if (this.successTag == null) {
        missing += " successTag";
      }
      if (this.failureTag == null) {
        missing += " failureTag";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_BigQueryConverters_FailsafeJsonToTableRow<T>(
          this.successTag,
          this.failureTag);
    }
  }

}
