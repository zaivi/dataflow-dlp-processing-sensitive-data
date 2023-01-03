package com.google.cloud.teleport.templates.common;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_JavascriptTextTransformer_TransformTextViaJavascript extends JavascriptTextTransformer.TransformTextViaJavascript {

  private final ValueProvider<String> fileSystemPath;

  private final ValueProvider<String> functionName;

  private AutoValue_JavascriptTextTransformer_TransformTextViaJavascript(
      @Nullable ValueProvider<String> fileSystemPath,
      @Nullable ValueProvider<String> functionName) {
    this.fileSystemPath = fileSystemPath;
    this.functionName = functionName;
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

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof JavascriptTextTransformer.TransformTextViaJavascript) {
      JavascriptTextTransformer.TransformTextViaJavascript that = (JavascriptTextTransformer.TransformTextViaJavascript) o;
      return (this.fileSystemPath == null ? that.fileSystemPath() == null : this.fileSystemPath.equals(that.fileSystemPath()))
          && (this.functionName == null ? that.functionName() == null : this.functionName.equals(that.functionName()));
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
    return h$;
  }

  static final class Builder extends JavascriptTextTransformer.TransformTextViaJavascript.Builder {
    private ValueProvider<String> fileSystemPath;
    private ValueProvider<String> functionName;
    Builder() {
    }
    @Override
    public JavascriptTextTransformer.TransformTextViaJavascript.Builder setFileSystemPath(@Nullable ValueProvider<String> fileSystemPath) {
      this.fileSystemPath = fileSystemPath;
      return this;
    }
    @Override
    public JavascriptTextTransformer.TransformTextViaJavascript.Builder setFunctionName(@Nullable ValueProvider<String> functionName) {
      this.functionName = functionName;
      return this;
    }
    @Override
    public JavascriptTextTransformer.TransformTextViaJavascript build() {
      return new AutoValue_JavascriptTextTransformer_TransformTextViaJavascript(
          this.fileSystemPath,
          this.functionName);
    }
  }

}
