package com.google.cloud.teleport.templates.common;

import com.google.cloud.teleport.values.FailsafeElement;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.beam.sdk.values.TupleTag;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_JavascriptTextTransformer_FailsafeJavascriptUdf<T> extends JavascriptTextTransformer.FailsafeJavascriptUdf<T> {

  private final ValueProvider<String> fileSystemPath;

  private final ValueProvider<String> functionName;

  private final ValueProvider<Boolean> loggingEnabled;

  private final TupleTag<FailsafeElement<T, String>> successTag;

  private final TupleTag<FailsafeElement<T, String>> failureTag;

  private AutoValue_JavascriptTextTransformer_FailsafeJavascriptUdf(
      @Nullable ValueProvider<String> fileSystemPath,
      @Nullable ValueProvider<String> functionName,
      @Nullable ValueProvider<Boolean> loggingEnabled,
      TupleTag<FailsafeElement<T, String>> successTag,
      TupleTag<FailsafeElement<T, String>> failureTag) {
    this.fileSystemPath = fileSystemPath;
    this.functionName = functionName;
    this.loggingEnabled = loggingEnabled;
    this.successTag = successTag;
    this.failureTag = failureTag;
  }

  @Nullable
  @Override
  public ValueProvider<String> fileSystemPath() {
    return fileSystemPath;
  }

  @Nullable
  @Override
  public ValueProvider<String> functionName() {
    return functionName;
  }

  @Nullable
  @Override
  public ValueProvider<Boolean> loggingEnabled() {
    return loggingEnabled;
  }

  @Override
  public TupleTag<FailsafeElement<T, String>> successTag() {
    return successTag;
  }

  @Override
  public TupleTag<FailsafeElement<T, String>> failureTag() {
    return failureTag;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof JavascriptTextTransformer.FailsafeJavascriptUdf) {
      JavascriptTextTransformer.FailsafeJavascriptUdf<?> that = (JavascriptTextTransformer.FailsafeJavascriptUdf<?>) o;
      return (this.fileSystemPath == null ? that.fileSystemPath() == null : this.fileSystemPath.equals(that.fileSystemPath()))
          && (this.functionName == null ? that.functionName() == null : this.functionName.equals(that.functionName()))
          && (this.loggingEnabled == null ? that.loggingEnabled() == null : this.loggingEnabled.equals(that.loggingEnabled()))
          && this.successTag.equals(that.successTag())
          && this.failureTag.equals(that.failureTag());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (fileSystemPath == null) ? 0 : fileSystemPath.hashCode();
    h$ *= 1000003;
    h$ ^= (functionName == null) ? 0 : functionName.hashCode();
    h$ *= 1000003;
    h$ ^= (loggingEnabled == null) ? 0 : loggingEnabled.hashCode();
    h$ *= 1000003;
    h$ ^= successTag.hashCode();
    h$ *= 1000003;
    h$ ^= failureTag.hashCode();
    return h$;
  }

  static final class Builder<T> extends JavascriptTextTransformer.FailsafeJavascriptUdf.Builder<T> {
    private ValueProvider<String> fileSystemPath;
    private ValueProvider<String> functionName;
    private ValueProvider<Boolean> loggingEnabled;
    private TupleTag<FailsafeElement<T, String>> successTag;
    private TupleTag<FailsafeElement<T, String>> failureTag;
    Builder() {
    }
    @Override
    public JavascriptTextTransformer.FailsafeJavascriptUdf.Builder<T> setFileSystemPath(@Nullable ValueProvider<String> fileSystemPath) {
      this.fileSystemPath = fileSystemPath;
      return this;
    }
    @Override
    public JavascriptTextTransformer.FailsafeJavascriptUdf.Builder<T> setFunctionName(@Nullable ValueProvider<String> functionName) {
      this.functionName = functionName;
      return this;
    }
    @Override
    public JavascriptTextTransformer.FailsafeJavascriptUdf.Builder<T> setLoggingEnabled(@Nullable ValueProvider<Boolean> loggingEnabled) {
      this.loggingEnabled = loggingEnabled;
      return this;
    }
    @Override
    public JavascriptTextTransformer.FailsafeJavascriptUdf.Builder<T> setSuccessTag(TupleTag<FailsafeElement<T, String>> successTag) {
      if (successTag == null) {
        throw new NullPointerException("Null successTag");
      }
      this.successTag = successTag;
      return this;
    }
    @Override
    public JavascriptTextTransformer.FailsafeJavascriptUdf.Builder<T> setFailureTag(TupleTag<FailsafeElement<T, String>> failureTag) {
      if (failureTag == null) {
        throw new NullPointerException("Null failureTag");
      }
      this.failureTag = failureTag;
      return this;
    }
    @Override
    public JavascriptTextTransformer.FailsafeJavascriptUdf<T> build() {
      String missing = "";
      if (this.successTag == null) {
        missing += " successTag";
      }
      if (this.failureTag == null) {
        missing += " failureTag";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_JavascriptTextTransformer_FailsafeJavascriptUdf<T>(
          this.fileSystemPath,
          this.functionName,
          this.loggingEnabled,
          this.successTag,
          this.failureTag);
    }
  }

}
