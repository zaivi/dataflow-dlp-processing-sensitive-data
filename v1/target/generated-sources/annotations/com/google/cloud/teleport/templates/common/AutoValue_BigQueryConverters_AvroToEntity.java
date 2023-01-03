package com.google.cloud.teleport.templates.common;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_BigQueryConverters_AvroToEntity extends BigQueryConverters.AvroToEntity {

  private final ValueProvider<String> entityKind;

  private final ValueProvider<String> uniqueNameColumn;

  private final ValueProvider<String> namespace;

  private AutoValue_BigQueryConverters_AvroToEntity(
      ValueProvider<String> entityKind,
      ValueProvider<String> uniqueNameColumn,
      @Nullable ValueProvider<String> namespace) {
    this.entityKind = entityKind;
    this.uniqueNameColumn = uniqueNameColumn;
    this.namespace = namespace;
  }

  @Override
  public ValueProvider<String> entityKind() {
    return entityKind;
  }

  @Override
  public ValueProvider<String> uniqueNameColumn() {
    return uniqueNameColumn;
  }

  @Nullable
  @Override
  public ValueProvider<String> namespace() {
    return namespace;
  }

  @Override
  public String toString() {
    return "AvroToEntity{"
        + "entityKind=" + entityKind + ", "
        + "uniqueNameColumn=" + uniqueNameColumn + ", "
        + "namespace=" + namespace
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BigQueryConverters.AvroToEntity) {
      BigQueryConverters.AvroToEntity that = (BigQueryConverters.AvroToEntity) o;
      return this.entityKind.equals(that.entityKind())
          && this.uniqueNameColumn.equals(that.uniqueNameColumn())
          && (this.namespace == null ? that.namespace() == null : this.namespace.equals(that.namespace()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= entityKind.hashCode();
    h$ *= 1000003;
    h$ ^= uniqueNameColumn.hashCode();
    h$ *= 1000003;
    h$ ^= (namespace == null) ? 0 : namespace.hashCode();
    return h$;
  }

  static final class Builder extends BigQueryConverters.AvroToEntity.Builder {
    private ValueProvider<String> entityKind;
    private ValueProvider<String> uniqueNameColumn;
    private ValueProvider<String> namespace;
    Builder() {
    }
    @Override
    public BigQueryConverters.AvroToEntity.Builder setEntityKind(ValueProvider<String> entityKind) {
      if (entityKind == null) {
        throw new NullPointerException("Null entityKind");
      }
      this.entityKind = entityKind;
      return this;
    }
    @Override
    public BigQueryConverters.AvroToEntity.Builder setUniqueNameColumn(ValueProvider<String> uniqueNameColumn) {
      if (uniqueNameColumn == null) {
        throw new NullPointerException("Null uniqueNameColumn");
      }
      this.uniqueNameColumn = uniqueNameColumn;
      return this;
    }
    @Override
    public BigQueryConverters.AvroToEntity.Builder setNamespace(ValueProvider<String> namespace) {
      this.namespace = namespace;
      return this;
    }
    @Override
    public BigQueryConverters.AvroToEntity build() {
      String missing = "";
      if (this.entityKind == null) {
        missing += " entityKind";
      }
      if (this.uniqueNameColumn == null) {
        missing += " uniqueNameColumn";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_BigQueryConverters_AvroToEntity(
          this.entityKind,
          this.uniqueNameColumn,
          this.namespace);
    }
  }

}
