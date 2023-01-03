package com.google.cloud.teleport.templates.common;

import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DatastoreConverters_DatastoreDeleteEntityJson extends DatastoreConverters.DatastoreDeleteEntityJson {

  private final ValueProvider<String> projectId;

  private final ValueProvider<Integer> hintNumWorkers;

  private final Boolean throttleRampup;

  private AutoValue_DatastoreConverters_DatastoreDeleteEntityJson(
      ValueProvider<String> projectId,
      ValueProvider<Integer> hintNumWorkers,
      Boolean throttleRampup) {
    this.projectId = projectId;
    this.hintNumWorkers = hintNumWorkers;
    this.throttleRampup = throttleRampup;
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
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DatastoreConverters.DatastoreDeleteEntityJson) {
      DatastoreConverters.DatastoreDeleteEntityJson that = (DatastoreConverters.DatastoreDeleteEntityJson) o;
      return this.projectId.equals(that.projectId())
          && this.hintNumWorkers.equals(that.hintNumWorkers())
          && this.throttleRampup.equals(that.throttleRampup());
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
    return h$;
  }

  static final class Builder extends DatastoreConverters.DatastoreDeleteEntityJson.Builder {
    private ValueProvider<String> projectId;
    private ValueProvider<Integer> hintNumWorkers;
    private Boolean throttleRampup;
    Builder() {
    }
    @Override
    public DatastoreConverters.DatastoreDeleteEntityJson.Builder setProjectId(ValueProvider<String> projectId) {
      if (projectId == null) {
        throw new NullPointerException("Null projectId");
      }
      this.projectId = projectId;
      return this;
    }
    @Override
    public DatastoreConverters.DatastoreDeleteEntityJson.Builder setHintNumWorkers(ValueProvider<Integer> hintNumWorkers) {
      if (hintNumWorkers == null) {
        throw new NullPointerException("Null hintNumWorkers");
      }
      this.hintNumWorkers = hintNumWorkers;
      return this;
    }
    @Override
    public DatastoreConverters.DatastoreDeleteEntityJson.Builder setThrottleRampup(Boolean throttleRampup) {
      if (throttleRampup == null) {
        throw new NullPointerException("Null throttleRampup");
      }
      this.throttleRampup = throttleRampup;
      return this;
    }
    @Override
    public DatastoreConverters.DatastoreDeleteEntityJson build() {
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
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_DatastoreConverters_DatastoreDeleteEntityJson(
          this.projectId,
          this.hintNumWorkers,
          this.throttleRampup);
    }
  }

}
