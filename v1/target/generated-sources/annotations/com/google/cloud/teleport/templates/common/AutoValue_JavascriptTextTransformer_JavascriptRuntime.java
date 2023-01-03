package com.google.cloud.teleport.templates.common;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_JavascriptTextTransformer_JavascriptRuntime extends JavascriptTextTransformer.JavascriptRuntime {

  private final String fileSystemPath;

  private final String functionName;

  private AutoValue_JavascriptTextTransformer_JavascriptRuntime(
      @Nullable String fileSystemPath,
      @Nullable String functionName) {
    this.fileSystemPath = fileSystemPath;
    this.functionName = functionName;
  }

  @Nullable
  @Override
  public String fileSystemPath() {
    return fileSystemPath;
  }

  @Nullable
  @Override
  public String functionName() {
    return functionName;
  }

  @Override
  public String toString() {
    return "JavascriptRuntime{"
        + "fileSystemPath=" + fileSystemPath + ", "
        + "functionName=" + functionName
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof JavascriptTextTransformer.JavascriptRuntime) {
      JavascriptTextTransformer.JavascriptRuntime that = (JavascriptTextTransformer.JavascriptRuntime) o;
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

  static final class Builder extends JavascriptTextTransformer.JavascriptRuntime.Builder {
    private String fileSystemPath;
    private String functionName;
    Builder() {
    }
    @Override
    public JavascriptTextTransformer.JavascriptRuntime.Builder setFileSystemPath(@Nullable String fileSystemPath) {
      this.fileSystemPath = fileSystemPath;
      return this;
    }
    @Override
    public JavascriptTextTransformer.JavascriptRuntime.Builder setFunctionName(@Nullable String functionName) {
      this.functionName = functionName;
      return this;
    }
    @Override
    public JavascriptTextTransformer.JavascriptRuntime build() {
      return new AutoValue_JavascriptTextTransformer_JavascriptRuntime(
          this.fileSystemPath,
          this.functionName);
    }
  }

}
