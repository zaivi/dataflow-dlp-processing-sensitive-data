package com.google.cloud.teleport.templates.common;

import com.google.datastore.v1.Entity;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.values.TupleTag;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DatastoreConverters_CheckNoKey extends DatastoreConverters.CheckNoKey {

  private final TupleTag<Entity> successTag;

  private final TupleTag<String> failureTag;

  private AutoValue_DatastoreConverters_CheckNoKey(
      TupleTag<Entity> successTag,
      TupleTag<String> failureTag) {
    this.successTag = successTag;
    this.failureTag = failureTag;
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
    if (o instanceof DatastoreConverters.CheckNoKey) {
      DatastoreConverters.CheckNoKey that = (DatastoreConverters.CheckNoKey) o;
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

  static final class Builder extends DatastoreConverters.CheckNoKey.Builder {
    private TupleTag<Entity> successTag;
    private TupleTag<String> failureTag;
    Builder() {
    }
    @Override
    public DatastoreConverters.CheckNoKey.Builder setSuccessTag(TupleTag<Entity> successTag) {
      if (successTag == null) {
        throw new NullPointerException("Null successTag");
      }
      this.successTag = successTag;
      return this;
    }
    @Override
    public DatastoreConverters.CheckNoKey.Builder setFailureTag(TupleTag<String> failureTag) {
      if (failureTag == null) {
        throw new NullPointerException("Null failureTag");
      }
      this.failureTag = failureTag;
      return this;
    }
    @Override
    public DatastoreConverters.CheckNoKey build() {
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
      return new AutoValue_DatastoreConverters_CheckNoKey(
          this.successTag,
          this.failureTag);
    }
  }

}
