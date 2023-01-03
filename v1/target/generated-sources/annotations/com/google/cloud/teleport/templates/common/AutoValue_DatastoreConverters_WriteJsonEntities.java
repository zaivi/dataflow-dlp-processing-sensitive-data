package com.google.cloud.teleport.templates.common;

import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.beam.sdk.values.TupleTag;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DatastoreConverters_WriteJsonEntities extends DatastoreConverters.WriteJsonEntities {

  private final ValueProvider<String> projectId;

  private final ValueProvider<Integer> hintNumWorkers;

  private final Boolean throttleRampup;

  private final TupleTag<String> errorTag;

  private AutoValue_DatastoreConverters_WriteJsonEntities(
      ValueProvider<String> projectId,
      ValueProvider<Integer> hintNumWorkers,
      Boolean throttleRampup,
      TupleTag<String> errorTag) {
    this.projectId = projectId;
    this.hintNumWorkers = hintNumWorkers;
    this.throttleRampup = throttleRampup;
    this.errorTag = errorTag;
  }

  @Override
  public ValueProvider<String> projectId() {
    return projectId;
  }

  @Override
  public ValueProvider<Integer> hintNumWorkers() {
    return hintNumWorkers;
  }

  @Override
  public Boolean throttleRampup() {
    return throttleRampup;
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
    if (o instanceof DatastoreConverters.WriteJsonEntities) {
      DatastoreConverters.WriteJsonEntities that = (DatastoreConverters.WriteJsonEntities) o;
      return this.projectId.equals(that.projectId())
          && this.hintNumWorkers.equals(that.hintNumWorkers())
          && this.throttleRampup.equals(that.throttleRampup())
          && this.errorTag.equals(that.errorTag());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= projectId.hashCode();
    h$ *= 1000003;
    h$ ^= hintNumWorkers.hashCode();
    h$ *= 1000003;
    h$ ^= throttleRampup.hashCode();
    h$ *= 1000003;
    h$ ^= errorTag.hashCode();
    return h$;
  }

  static final class Builder extends DatastoreConverters.WriteJsonEntities.Builder {
    private ValueProvider<String> projectId;
    private ValueProvider<Integer> hintNumWorkers;
    private Boolean throttleRampup;
    private TupleTag<String> errorTag;
    Builder() {
    }
    @Override
    public DatastoreConverters.WriteJsonEntities.Builder setProjectId(ValueProvider<String> projectId) {
      if (projectId == null) {
        throw new NullPointerException("Null projectId");
      }
      this.projectId = projectId;
      return this;
    }
    @Override
    public DatastoreConverters.WriteJsonEntities.Builder setHintNumWorkers(ValueProvider<Integer> hintNumWorkers) {
      if (hintNumWorkers == null) {
        throw new NullPointerException("Null hintNumWorkers");
      }
      this.hintNumWorkers = hintNumWorkers;
      return this;
    }
    @Override
    public DatastoreConverters.WriteJsonEntities.Builder setThrottleRampup(Boolean throttleRampup) {
      if (throttleRampup == null) {
        throw new NullPointerException("Null throttleRampup");
      }
      this.throttleRampup = throttleRampup;
      return this;
    }
    @Override
    public DatastoreConverters.WriteJsonEntities.Builder setErrorTag(TupleTag<String> errorTag) {
      if (errorTag == null) {
        throw new NullPointerException("Null errorTag");
      }
      this.errorTag = errorTag;
      return this;
    }
    @Override
    public DatastoreConverters.WriteJsonEntities build() {
      String missing = "";
      if (this.projectId == null) {
        missing += " projectId";
      }
      if (this.hintNumWorkers == null) {
        missing += " hintNumWorkers";
      }
      if (this.throttleRampup == null) {
        missing += " throttleRampup";
      }
      if (this.errorTag == null) {
        missing += " errorTag";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_DatastoreConverters_WriteJsonEntities(
          this.projectId,
          this.hintNumWorkers,
          this.throttleRampup,
          this.errorTag);
    }
  }

}
