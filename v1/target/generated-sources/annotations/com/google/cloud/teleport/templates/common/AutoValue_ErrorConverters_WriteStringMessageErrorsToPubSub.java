package com.google.cloud.teleport.templates.common;

import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ErrorConverters_WriteStringMessageErrorsToPubSub extends ErrorConverters.WriteStringMessageErrorsToPubSub {

  private final ValueProvider<String> errorRecordsTopic;

  private AutoValue_ErrorConverters_WriteStringMessageErrorsToPubSub(
      ValueProvider<String> errorRecordsTopic) {
    this.errorRecordsTopic = errorRecordsTopic;
  }

  @Override
  public ValueProvider<String> errorRecordsTopic() {
    return errorRecordsTopic;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ErrorConverters.WriteStringMessageErrorsToPubSub) {
      ErrorConverters.WriteStringMessageErrorsToPubSub that = (ErrorConverters.WriteStringMessageErrorsToPubSub) o;
      return this.errorRecordsTopic.equals(that.errorRecordsTopic());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= errorRecordsTopic.hashCode();
    return h$;
  }

  static final class Builder extends ErrorConverters.WriteStringMessageErrorsToPubSub.Builder {
    private ValueProvider<String> errorRecordsTopic;
    Builder() {
    }
    @Override
    public ErrorConverters.WriteStringMessageErrorsToPubSub.Builder setErrorRecordsTopic(ValueProvider<String> errorRecordsTopic) {
      if (errorRecordsTopic == null) {
        throw new NullPointerException("Null errorRecordsTopic");
      }
      this.errorRecordsTopic = errorRecordsTopic;
      return this;
    }
    @Override
    public ErrorConverters.WriteStringMessageErrorsToPubSub build() {
      String missing = "";
      if (this.errorRecordsTopic == null) {
        missing += " errorRecordsTopic";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_ErrorConverters_WriteStringMessageErrorsToPubSub(
          this.errorRecordsTopic);
    }
  }

}
