package com.google.cloud.teleport.splunk;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SplunkEventWriter extends SplunkEventWriter {

  private final ValueProvider<String> url;

  private final ValueProvider<String> token;

  private final ValueProvider<Boolean> disableCertificateValidation;

  private final ValueProvider<String> rootCaCertificatePath;

  private final ValueProvider<Boolean> enableBatchLogs;

  private final ValueProvider<Boolean> enableGzipHttpCompression;

  private final ValueProvider<Integer> inputBatchCount;

  private AutoValue_SplunkEventWriter(
      @Nullable ValueProvider<String> url,
      @Nullable ValueProvider<String> token,
      @Nullable ValueProvider<Boolean> disableCertificateValidation,
      @Nullable ValueProvider<String> rootCaCertificatePath,
      @Nullable ValueProvider<Boolean> enableBatchLogs,
      @Nullable ValueProvider<Boolean> enableGzipHttpCompression,
      @Nullable ValueProvider<Integer> inputBatchCount) {
    this.url = url;
    this.token = token;
    this.disableCertificateValidation = disableCertificateValidation;
    this.rootCaCertificatePath = rootCaCertificatePath;
    this.enableBatchLogs = enableBatchLogs;
    this.enableGzipHttpCompression = enableGzipHttpCompression;
    this.inputBatchCount = inputBatchCount;
  }

  @Nullable
  @Override
  ValueProvider<String> url() {
    return url;
  }

  @Nullable
  @Override
  ValueProvider<String> token() {
    return token;
  }

  @Nullable
  @Override
  ValueProvider<Boolean> disableCertificateValidation() {
    return disableCertificateValidation;
  }

  @Nullable
  @Override
  ValueProvider<String> rootCaCertificatePath() {
    return rootCaCertificatePath;
  }

  @Nullable
  @Override
  ValueProvider<Boolean> enableBatchLogs() {
    return enableBatchLogs;
  }

  @Nullable
  @Override
  ValueProvider<Boolean> enableGzipHttpCompression() {
    return enableGzipHttpCompression;
  }

  @Nullable
  @Override
  ValueProvider<Integer> inputBatchCount() {
    return inputBatchCount;
  }

  @Override
  public String toString() {
    return "SplunkEventWriter{"
        + "url=" + url + ", "
        + "token=" + token + ", "
        + "disableCertificateValidation=" + disableCertificateValidation + ", "
        + "rootCaCertificatePath=" + rootCaCertificatePath + ", "
        + "enableBatchLogs=" + enableBatchLogs + ", "
        + "enableGzipHttpCompression=" + enableGzipHttpCompression + ", "
        + "inputBatchCount=" + inputBatchCount
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SplunkEventWriter) {
      SplunkEventWriter that = (SplunkEventWriter) o;
      return (this.url == null ? that.url() == null : this.url.equals(that.url()))
          && (this.token == null ? that.token() == null : this.token.equals(that.token()))
          && (this.disableCertificateValidation == null ? that.disableCertificateValidation() == null : this.disableCertificateValidation.equals(that.disableCertificateValidation()))
          && (this.rootCaCertificatePath == null ? that.rootCaCertificatePath() == null : this.rootCaCertificatePath.equals(that.rootCaCertificatePath()))
          && (this.enableBatchLogs == null ? that.enableBatchLogs() == null : this.enableBatchLogs.equals(that.enableBatchLogs()))
          && (this.enableGzipHttpCompression == null ? that.enableGzipHttpCompression() == null : this.enableGzipHttpCompression.equals(that.enableGzipHttpCompression()))
          && (this.inputBatchCount == null ? that.inputBatchCount() == null : this.inputBatchCount.equals(that.inputBatchCount()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (url == null) ? 0 : url.hashCode();
    h$ *= 1000003;
    h$ ^= (token == null) ? 0 : token.hashCode();
    h$ *= 1000003;
    h$ ^= (disableCertificateValidation == null) ? 0 : disableCertificateValidation.hashCode();
    h$ *= 1000003;
    h$ ^= (rootCaCertificatePath == null) ? 0 : rootCaCertificatePath.hashCode();
    h$ *= 1000003;
    h$ ^= (enableBatchLogs == null) ? 0 : enableBatchLogs.hashCode();
    h$ *= 1000003;
    h$ ^= (enableGzipHttpCompression == null) ? 0 : enableGzipHttpCompression.hashCode();
    h$ *= 1000003;
    h$ ^= (inputBatchCount == null) ? 0 : inputBatchCount.hashCode();
    return h$;
  }

  static final class Builder extends SplunkEventWriter.Builder {
    private ValueProvider<String> url;
    private ValueProvider<String> token;
    private ValueProvider<Boolean> disableCertificateValidation;
    private ValueProvider<String> rootCaCertificatePath;
    private ValueProvider<Boolean> enableBatchLogs;
    private ValueProvider<Boolean> enableGzipHttpCompression;
    private ValueProvider<Integer> inputBatchCount;
    Builder() {
    }
    @Override
    SplunkEventWriter.Builder setUrl(ValueProvider<String> url) {
      this.url = url;
      return this;
    }
    @Override
    @Nullable ValueProvider<String> url() {
      return url;
    }
    @Override
    SplunkEventWriter.Builder setToken(ValueProvider<String> token) {
      this.token = token;
      return this;
    }
    @Override
    @Nullable ValueProvider<String> token() {
      return token;
    }
    @Override
    SplunkEventWriter.Builder setDisableCertificateValidation(ValueProvider<Boolean> disableCertificateValidation) {
      this.disableCertificateValidation = disableCertificateValidation;
      return this;
    }
    @Override
    SplunkEventWriter.Builder setRootCaCertificatePath(ValueProvider<String> rootCaCertificatePath) {
      this.rootCaCertificatePath = rootCaCertificatePath;
      return this;
    }
    @Override
    SplunkEventWriter.Builder setEnableBatchLogs(ValueProvider<Boolean> enableBatchLogs) {
      this.enableBatchLogs = enableBatchLogs;
      return this;
    }
    @Override
    SplunkEventWriter.Builder setEnableGzipHttpCompression(ValueProvider<Boolean> enableGzipHttpCompression) {
      this.enableGzipHttpCompression = enableGzipHttpCompression;
      return this;
    }
    @Override
    SplunkEventWriter.Builder setInputBatchCount(ValueProvider<Integer> inputBatchCount) {
      this.inputBatchCount = inputBatchCount;
      return this;
    }
    @Override
    SplunkEventWriter autoBuild() {
      return new AutoValue_SplunkEventWriter(
          this.url,
          this.token,
          this.disableCertificateValidation,
          this.rootCaCertificatePath,
          this.enableBatchLogs,
          this.enableGzipHttpCompression,
          this.inputBatchCount);
    }
  }

}
