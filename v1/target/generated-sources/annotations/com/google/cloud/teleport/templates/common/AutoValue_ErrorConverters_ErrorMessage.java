package com.google.cloud.teleport.templates.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_ErrorConverters_ErrorMessage<T> extends ErrorConverters.ErrorMessage<T> {

  private final String message;

  private final String stacktrace;

  private final T data;

  private AutoValue_ErrorConverters_ErrorMessage(
      String message,
      @Nullable String stacktrace,
      T data) {
    this.message = message;
    this.stacktrace = stacktrace;
    this.data = data;
  }

  @JsonProperty
  @Override
  public String message() {
    return message;
  }

  @JsonProperty
  @Nullable
  @Override
  public String stacktrace() {
    return stacktrace;
  }

  @JsonProperty
  @Override
  public T data() {
    return data;
  }

  @Override
  public String toString() {
    return "ErrorMessage{"
        + "message=" + message + ", "
        + "stacktrace=" + stacktrace + ", "
        + "data=" + data
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ErrorConverters.ErrorMessage) {
      ErrorConverters.ErrorMessage<?> that = (ErrorConverters.ErrorMessage<?>) o;
      return this.message.equals(that.message())
          && (this.stacktrace == null ? that.stacktrace() == null : this.stacktrace.equals(that.stacktrace()))
          && this.data.equals(that.data());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= message.hashCode();
    h$ *= 1000003;
    h$ ^= (stacktrace == null) ? 0 : stacktrace.hashCode();
    h$ *= 1000003;
    h$ ^= data.hashCode();
    return h$;
  }

  static final class Builder<T> extends ErrorConverters.ErrorMessage.Builder<T> {
    private String message;
    private String stacktrace;
    private T data;
    Builder() {
    }
    @Override
    public ErrorConverters.ErrorMessage.Builder<T> setMessage(String message) {
      if (message == null) {
        throw new NullPointerException("Null message");
      }
      this.message = message;
      return this;
    }
    @Override
    public ErrorConverters.ErrorMessage.Builder<T> setStacktrace(@Nullable String stacktrace) {
      this.stacktrace = stacktrace;
      return this;
    }
    @Override
    public ErrorConverters.ErrorMessage.Builder<T> setData(T data) {
      if (data == null) {
        throw new NullPointerException("Null data");
      }
      this.data = data;
      return this;
    }
    @Override
    public ErrorConverters.ErrorMessage<T> build() {
      String missing = "";
      if (this.message == null) {
        missing += " message";
      }
      if (this.data == null) {
        missing += " data";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_ErrorConverters_ErrorMessage<T>(
          this.message,
          this.stacktrace,
          this.data);
    }
  }

}
