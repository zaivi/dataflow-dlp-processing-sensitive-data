package com.google.cloud.teleport.templates.common;

import com.google.datastore.v1.Entity;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.values.TupleTag;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DatastoreConverters_CheckSameKey extends DatastoreConverters.CheckSameKey {

  private final TupleTag<Entity> goodTag;

  private final TupleTag<String> errorTag;

  private AutoValue_DatastoreConverters_CheckSameKey(
      TupleTag<Entity> goodTag,
      TupleTag<String> errorTag) {
    this.goodTag = goodTag;
    this.errorTag = errorTag;
  }

  @Override
  public TupleTag<Entity> goodTag() {
    return goodTag;
  }

  @Override
  public TupleTag<String> errorTag() {
    return errorTag;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DatastoreConverters.CheckSameKey) {
      DatastoreConverters.CheckSameKey that = (DatastoreConverters.CheckSameKey) o;
      return this.goodTag.equals(that.goodTag())
          && this.errorTag.equals(that.errorTag());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= goodTag.hashCode();
    h$ *= 1000003;
    h$ ^= errorTag.hashCode();
    return h$;
  }

  static final class Builder extends DatastoreConverters.CheckSameKey.Builder {
    private TupleTag<Entity> goodTag;
    private TupleTag<String> errorTag;
    Builder() {
    }
    @Override
    public DatastoreConverters.CheckSameKey.Builder setGoodTag(TupleTag<Entity> goodTag) {
      if (goodTag == null) {
        throw new NullPointerException("Null goodTag");
      }
      this.goodTag = goodTag;
      return this;
    }
    @Override
    public DatastoreConverters.CheckSameKey.Builder setErrorTag(TupleTag<String> errorTag) {
      if (errorTag == null) {
        throw new NullPointerException("Null errorTag");
      }
      this.errorTag = errorTag;
      return this;
    }
    @Override
    public DatastoreConverters.CheckSameKey build() {
      String missing = "";
      if (this.goodTag == null) {
        missing += " goodTag";
      }
      if (this.errorTag == null) {
        missing += " errorTag";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_DatastoreConverters_CheckSameKey(
          this.goodTag,
          this.errorTag);
    }
  }

}
