package com.google.cloud.teleport.splunk;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SplunkIO_Write extends SplunkIO.Write {

  private final ValueProvider<String> url;

  private final ValueProvider<String> token;

  private final ValueProvider<Integer> batchCount;

  private final ValueProvider<Integer> parallelism;

  private final ValueProvider<Boolean> disableCertificateValidation;

  private final ValueProvider<String> rootCaCertificatePath;

  private final ValueProvider<Boolean> enableBatchLogs;

  private final ValueProvider<Boolean> enableGzipHttpCompression;

  private AutoValue_SplunkIO_Write(
      @Nullable ValueProvider<String> url,
      @Nullable ValueProvider<String> token,
      @Nullable ValueProvider<Integer> batchCount,
      @Nullable ValueProvider<Integer> parallelism,
      @Nullable ValueProvider<Boolean> disableCertificateValidation,
      @Nullable ValueProvider<String> rootCaCertificatePath,
      @Nullable ValueProvider<Boolean> enableBatchLogs,
      @Nullable ValueProvider<Boolean> enableGzipHttpCompression) {
    this.url = url;
    this.token = token;
    this.batchCount = batchCount;
    this.parallelism = parallelism;
    this.disableCertificateValidation = disableCertificateValidation;
    this.rootCaCertificatePath = rootCaCertificatePath;
    this.enableBatchLogs = enableBatchLogs;
    this.enableGzipHttpCompression = enableGzipHttpCompression;
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
  ValueProvider<Integer> batchCount() {
    return batchCount;
  }

  @Nullable
  @Override
  ValueProvider<Integer> parallelism() {
    return parallelism;
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

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SplunkIO.Write) {
      SplunkIO.Write that = (SplunkIO.Write) o;
      return (this.url == null ? that.url() == null : this.url.equals(that.url()))
          && (this.token == null ? that.token() == null : this.token.equals(that.token()))
          && (this.batchCount == null ? that.batchCount() == null : this.batchCount.equals(that.batchCount()))
          && (this.parallelism == null ? that.parallelism() == null : this.parallelism.equals(that.parallelism()))
          && (this.disableCertificateValidation == null ? that.disableCertificateValidation() == null : this.disableCertificateValidation.equals(that.disableCertificateValidation()))
          && (this.rootCaCertificatePath == null ? that.rootCaCertificatePath() == null : this.rootCaCertificatePath.equals(that.rootCaCertificatePath()))
          && (this.enableBatchLogs == null ? that.enableBatchLogs() == null : this.enableBatchLogs.equals(that.enableBatchLogs()))
          && (this.enableGzipHttpCompression == null ? that.enableGzipHttpCompression() == null : this.enableGzipHttpCompression.equals(that.enableGzipHttpCompression()));
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
    h$ ^= (batchCount == null) ? 0 : batchCount.hashCode();
    h$ *= 1000003;
    h$ ^= (parallelism == null) ? 0 : parallelism.hashCode();
    h$ *= 1000003;
    h$ ^= (disableCertificateValidation == null) ? 0 : disableCertificateValidation.hashCode();
    h$ *= 1000003;
    h$ ^= (rootCaCertificatePath == null) ? 0 : rootCaCertificatePath.hashCode();
    h$ *= 1000003;
    h$ ^= (enableBatchLogs == null) ? 0 : enableBatchLogs.hashCode();
    h$ *= 1000003;
    h$ ^= (enableGzipHttpCompression == null) ? 0 : enableGzipHttpCompression.hashCode();
    return h$;
  }

  static final class Builder extends SplunkIO.Write.Builder {
    private ValueProvider<String> url;
    private ValueProvider<String> token;
    private ValueProvider<Integer> batchCount;
    private ValueProvider<Integer> parallelism;
    private ValueProvider<Boolean> disableCertificateValidation;
    private ValueProvider<String> rootCaCertificatePath;
    private ValueProvider<Boolean> enableBatchLogs;
    private ValueProvider<Boolean> enableGzipHttpCompression;
    Builder() {
    }
    @Override
    SplunkIO.Write.Builder setUrl(ValueProvider<String> url) {
      this.url = url;
      return this;
    }
    @Override
    @Nullable ValueProvider<String> url() {
      return url;
    }
    @Override
    SplunkIO.Write.Builder setToken(ValueProvider<String> token) {
      this.token = token;
      return this;
    }
    @Override
    @Nullable ValueProvider<String> token() {
      return token;
    }
    @Override
    SplunkIO.Write.Builder setBatchCount(ValueProvider<Integer> batchCount) {
      this.batchCount = batchCount;
      return this;
    }
    @Override
    SplunkIO.Write.Builder setParallelism(ValueProvider<Integer> parallelism) {
      this.parallelism = parallelism;
      return this;
    }
    @Override
    SplunkIO.Write.Builder setDisableCertificateValidation(ValueProvider<Boolean> disableCertificateValidation) {
      this.disableCertificateValidation = disableCertificateValidation;
      return this;
    }
    @Override
    SplunkIO.Write.Builder setRootCaCertificatePath(ValueProvider<String> rootCaCertificatePath) {
      this.rootCaCertificatePath = rootCaCertificatePath;
      return this;
    }
    @Override
    SplunkIO.Write.Builder setEnableBatchLogs(ValueProvider<Boolean> enableBatchLogs) {
      this.enableBatchLogs = enableBatchLogs;
      return this;
    }
    @Override
    SplunkIO.Write.Builder setEnableGzipHttpCompression(ValueProvider<Boolean> enableGzipHttpCompression) {
      this.enableGzipHttpCompression = enableGzipHttpCompression;
      return this;
    }
    @Override
    SplunkIO.Write autoBuild() {
      return new AutoValue_SplunkIO_Write(
          this.url,
          this.token,
          this.batchCount,
          this.parallelism,
          this.disableCertificateValidation,
          this.rootCaCertificatePath,
          this.enableBatchLogs,
          this.enableGzipHttpCompression);
    }
  }

}
