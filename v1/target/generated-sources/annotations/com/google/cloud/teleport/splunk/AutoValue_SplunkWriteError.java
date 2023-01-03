package com.google.cloud.teleport.splunk;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SplunkWriteError extends SplunkWriteError {

  private final Integer statusCode;

  private final String statusMessage;

  private final String payload;

  private AutoValue_SplunkWriteError(
      @Nullable Integer statusCode,
      @Nullable String statusMessage,
      @Nullable String payload) {
    this.statusCode = statusCode;
    this.statusMessage = statusMessage;
    this.payload = payload;
  }

  @Nullable
  @Override
  public Integer statusCode() {
    return statusCode;
  }

  @Nullable
  @Override
  public String statusMessage() {
    return statusMessage;
  }

  @Nullable
  @Override
  public String payload() {
    return payload;
  }

  @Override
  public String toString() {
    return "SplunkWriteError{"
        + "statusCode=" + statusCode + ", "
        + "statusMessage=" + statusMessage + ", "
        + "payload=" + payload
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SplunkWriteError) {
      SplunkWriteError that = (SplunkWriteError) o;
      return (this.statusCode == null ? that.statusCode() == null : this.statusCode.equals(that.statusCode()))
          && (this.statusMessage == null ? that.statusMessage() == null : this.statusMessage.equals(that.statusMessage()))
          && (this.payload == null ? that.payload() == null : this.payload.equals(that.payload()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (statusCode == null) ? 0 : statusCode.hashCode();
    h$ *= 1000003;
    h$ ^= (statusMessage == null) ? 0 : statusMessage.hashCode();
    h$ *= 1000003;
    h$ ^= (payload == null) ? 0 : payload.hashCode();
    return h$;
  }

  static final class Builder extends SplunkWriteError.Builder {
    private Integer statusCode;
    private String statusMessage;
    private String payload;
    Builder() {
    }
    @Override
    SplunkWriteError.Builder setStatusCode(Integer statusCode) {
      this.statusCode = statusCode;
      return this;
    }
    @Override
    @Nullable Integer statusCode() {
      return statusCode;
    }
    @Override
    SplunkWriteError.Builder setStatusMessage(String statusMessage) {
      this.statusMessage = statusMessage;
      return this;
    }
    @Override
    SplunkWriteError.Builder setPayload(String payload) {
      this.payload = payload;
      return this;
    }
    @Override
    SplunkWriteError autoBuild() {
      return new AutoValue_SplunkWriteError(
          this.statusCode,
          this.statusMessage,
          this.payload);
    }
  }

}
