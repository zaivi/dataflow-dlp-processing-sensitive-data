package com.google.cloud.teleport.templates.common;

import com.google.datastore.v1.Entity;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.beam.sdk.values.TupleTag;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_BigQueryConverters_BigQueryToEntity extends BigQueryConverters.BigQueryToEntity {

  private final ValueProvider<String> query;

  private final ValueProvider<String> entityKind;

  private final ValueProvider<String> uniqueNameColumn;

  private final ValueProvider<String> namespace;

  private final TupleTag<Entity> successTag;

  private final TupleTag<String> failureTag;

  private AutoValue_BigQueryConverters_BigQueryToEntity(
      ValueProvider<String> query,
      ValueProvider<String> entityKind,
      ValueProvider<String> uniqueNameColumn,
      @Nullable ValueProvider<String> namespace,
      TupleTag<Entity> successTag,
      TupleTag<String> failureTag) {
    this.query = query;
    this.entityKind = entityKind;
    this.uniqueNameColumn = uniqueNameColumn;
    this.namespace = namespace;
    this.successTag = successTag;
    this.failureTag = failureTag;
  }

  @Override
  ValueProvider<String> query() {
    return query;
  }

  @Override
  ValueProvider<String> entityKind() {
    return entityKind;
  }

  @Override
  ValueProvider<String> uniqueNameColumn() {
    return uniqueNameColumn;
  }

  @Nullable
  @Override
  ValueProvider<String> namespace() {
    return namespace;
  }

  @Override
  TupleTag<Entity> successTag() {
    return successTag;
  }

  @Override
  TupleTag<String> failureTag() {
    return failureTag;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BigQueryConverters.BigQueryToEntity) {
      BigQueryConverters.BigQueryToEntity that = (BigQueryConverters.BigQueryToEntity) o;
      return this.query.equals(that.query())
          && this.entityKind.equals(that.entityKind())
          && this.uniqueNameColumn.equals(that.uniqueNameColumn())
          && (this.namespace == null ? that.namespace() == null : this.namespace.equals(that.namespace()))
          && this.successTag.equals(that.successTag())
          && this.failureTag.equals(that.failureTag());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= query.hashCode();
    h$ *= 1000003;
    h$ ^= entityKind.hashCode();
    h$ *= 1000003;
    h$ ^= uniqueNameColumn.hashCode();
    h$ *= 1000003;
    h$ ^= (namespace == null) ? 0 : namespace.hashCode();
    h$ *= 1000003;
    h$ ^= successTag.hashCode();
    h$ *= 1000003;
    h$ ^= failureTag.hashCode();
    return h$;
  }

  static final class Builder extends BigQueryConverters.BigQueryToEntity.Builder {
    private ValueProvider<String> query;
    private ValueProvider<String> entityKind;
    private ValueProvider<String> uniqueNameColumn;
    private ValueProvider<String> namespace;
    private TupleTag<Entity> successTag;
    private TupleTag<String> failureTag;
    Builder() {
    }
    @Override
    public BigQueryConverters.BigQueryToEntity.Builder setQuery(ValueProvider<String> query) {
      if (query == null) {
        throw new NullPointerException("Null query");
      }
      this.query = query;
      return this;
    }
    @Override
    public BigQueryConverters.BigQueryToEntity.Builder setEntityKind(ValueProvider<String> entityKind) {
      if (entityKind == null) {
        throw new NullPointerException("Null entityKind");
      }
      this.entityKind = entityKind;
      return this;
    }
    @Override
    public BigQueryConverters.BigQueryToEntity.Builder setUniqueNameColumn(ValueProvider<String> uniqueNameColumn) {
      if (uniqueNameColumn == null) {
        throw new NullPointerException("Null uniqueNameColumn");
      }
      this.uniqueNameColumn = uniqueNameColumn;
      return this;
    }
    @Override
    public BigQueryConverters.BigQueryToEntity.Builder setNamespace(ValueProvider<String> namespace) {
      this.namespace = namespace;
      return this;
    }
    @Override
    public BigQueryConverters.BigQueryToEntity.Builder setSuccessTag(TupleTag<Entity> successTag) {
      if (successTag == null) {
        throw new NullPointerException("Null successTag");
      }
      this.successTag = successTag;
      return this;
    }
    @Override
    public BigQueryConverters.BigQueryToEntity.Builder setFailureTag(TupleTag<String> failureTag) {
      if (failureTag == null) {
        throw new NullPointerException("Null failureTag");
      }
      this.failureTag = failureTag;
      return this;
    }
    @Override
    public BigQueryConverters.BigQueryToEntity build() {
      String missing = "";
      if (this.query == null) {
        missing += " query";
      }
      if (this.entityKind == null) {
        missing += " entityKind";
      }
      if (this.uniqueNameColumn == null) {
        missing += " uniqueNameColumn";
      }
      if (this.successTag == null) {
        missing += " successTag";
      }
      if (this.failureTag == null) {
        missing += " failureTag";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_BigQueryConverters_BigQueryToEntity(
          this.query,
          this.entityKind,
          this.uniqueNameColumn,
          this.namespace,
          this.successTag,
          this.failureTag);
    }
  }

}
