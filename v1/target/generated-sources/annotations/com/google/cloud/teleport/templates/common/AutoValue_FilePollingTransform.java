package com.google.cloud.teleport.templates.common;

import javax.annotation.processing.Generated;
import org.joda.time.Duration;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_FilePollingTransform extends FilePollingTransform {

  private final String filePattern;

  private final Duration interval;

  private AutoValue_FilePollingTransform(
      String filePattern,
      Duration interval) {
    this.filePattern = filePattern;
    this.interval = interval;
  }

  @Override
  public String filePattern() {
    return filePattern;
  }

  @Override
  public Duration interval() {
    return interval;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FilePollingTransform) {
      FilePollingTransform that = (FilePollingTransform) o;
      return this.filePattern.equals(that.filePattern())
          && this.interval.equals(that.interval());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= filePattern.hashCode();
    h$ *= 1000003;
    h$ ^= interval.hashCode();
    return h$;
  }

  static final class Builder extends FilePollingTransform.Builder {
    private String filePattern;
    private Duration interval;
    Builder() {
    }
    @Override
    public FilePollingTransform.Builder setFilePattern(String filePattern) {
      if (filePattern == null) {
        throw new NullPointerException("Null filePattern");
      }
      this.filePattern = filePattern;
      return this;
    }
    @Override
    public FilePollingTransform.Builder setInterval(Duration interval) {
      if (interval == null) {
        throw new NullPointerException("Null interval");
      }
      this.interval = interval;
      return this;
    }
    @Override
    public FilePollingTransform build() {
      String missing = "";
      if (this.filePattern == null) {
        missing += " filePattern";
      }
      if (this.interval == null) {
        missing += " interval";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_FilePollingTransform(
          this.filePattern,
          this.interval);
    }
  }

}
