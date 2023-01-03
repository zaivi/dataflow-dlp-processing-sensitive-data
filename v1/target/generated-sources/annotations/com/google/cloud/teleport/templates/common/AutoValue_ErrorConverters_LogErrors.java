package com.google.cloud.teleport.templates.common;

import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.beam.sdk.values.TupleTag;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ErrorConverters_LogErrors extends ErrorConverters.LogErrors {

  private final ValueProvider<String> errorWritePath;

  private final TupleTag<String> errorTag;

  private AutoValue_ErrorConverters_LogErrors(
      ValueProvider<String> errorWritePath,
      TupleTag<String> errorTag) {
    this.errorWritePath = errorWritePath;
    this.errorTag = errorTag;
  }

  @Override
  public ValueProvider<String> errorWritePath() {
    return errorWritePath;
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
    if (o instanceof ErrorConverters.LogErrors) {
      ErrorConverters.LogErrors that = (ErrorConverters.LogErrors) o;
      return this.errorWritePath.equals(that.errorWritePath())
          && this.errorTag.equals(that.errorTag());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= errorWritePath.hashCode();
    h$ *= 1000003;
    h$ ^= errorTag.hashCode();
    return h$;
  }

  static final class Builder extends ErrorConverters.LogErrors.Builder {
    private ValueProvider<String> errorWritePath;
    private TupleTag<String> errorTag;
    Builder() {
    }
    @Override
    public ErrorConverters.LogErrors.Builder setErrorWritePath(ValueProvider<String> errorWritePath) {
      if (errorWritePath == null) {
        throw new NullPointerException("Null errorWritePath");
      }
      this.errorWritePath = errorWritePath;
      return this;
    }
    @Override
    public ErrorConverters.LogErrors.Builder setErrorTag(TupleTag<String> errorTag) {
      if (errorTag == null) {
        throw new NullPointerException("Null errorTag");
      }
      this.errorTag = errorTag;
      return this;
    }
    @Override
    public ErrorConverters.LogErrors build() {
      String missing = "";
      if (this.errorWritePath == null) {
        missing += " errorWritePath";
      }
      if (this.errorTag == null) {
        missing += " errorTag";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_ErrorConverters_LogErrors(
          this.errorWritePath,
          this.errorTag);
    }
  }

}
