package com.google.cloud.teleport.templates.common;

import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_BigQueryReadTransform extends BigQueryReadTransform {

  private final ValueProvider<String> tableRef;

  private final ValueProvider<Integer> keyRange;

  private final ValueProvider<String> query;

  private AutoValue_BigQueryReadTransform(
      ValueProvider<String> tableRef,
      ValueProvider<Integer> keyRange,
      ValueProvider<String> query) {
    this.tableRef = tableRef;
    this.keyRange = keyRange;
    this.query = query;
  }

  @Override
  public ValueProvider<String> tableRef() {
    return tableRef;
  }

  @Override
  public ValueProvider<Integer> keyRange() {
    return keyRange;
  }

  @Override
  public ValueProvider<String> query() {
    return query;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BigQueryReadTransform) {
      BigQueryReadTransform that = (BigQueryReadTransform) o;
      return this.tableRef.equals(that.tableRef())
          && this.keyRange.equals(that.keyRange())
          && this.query.equals(that.query());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= tableRef.hashCode();
    h$ *= 1000003;
    h$ ^= keyRange.hashCode();
    h$ *= 1000003;
    h$ ^= query.hashCode();
    return h$;
  }

  static final class Builder extends BigQueryReadTransform.Builder {
    private ValueProvider<String> tableRef;
    private ValueProvider<Integer> keyRange;
    private ValueProvider<String> query;
    Builder() {
    }
    @Override
    public BigQueryReadTransform.Builder setTableRef(ValueProvider<String> tableRef) {
      if (tableRef == null) {
        throw new NullPointerException("Null tableRef");
      }
      this.tableRef = tableRef;
      return this;
    }
    @Override
    public BigQueryReadTransform.Builder setKeyRange(ValueProvider<Integer> keyRange) {
      if (keyRange == null) {
        throw new NullPointerException("Null keyRange");
      }
      this.keyRange = keyRange;
      return this;
    }
    @Override
    public BigQueryReadTransform.Builder setQuery(ValueProvider<String> query) {
      if (query == null) {
        throw new NullPointerException("Null query");
      }
      this.query = query;
      return this;
    }
    @Override
    public BigQueryReadTransform build() {
      String missing = "";
      if (this.tableRef == null) {
        missing += " tableRef";
      }
      if (this.keyRange == null) {
        missing += " keyRange";
      }
      if (this.query == null) {
        missing += " query";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_BigQueryReadTransform(
          this.tableRef,
          this.keyRange,
          this.query);
    }
  }

}
