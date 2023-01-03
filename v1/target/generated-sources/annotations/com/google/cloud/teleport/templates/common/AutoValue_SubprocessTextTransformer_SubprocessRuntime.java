package com.google.cloud.teleport.templates.common;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SubprocessTextTransformer_SubprocessRuntime extends SubprocessTextTransformer.SubprocessRuntime {

  private final String fileSystemPath;

  private final String runtimeVersion;

  private final String functionName;

  private AutoValue_SubprocessTextTransformer_SubprocessRuntime(
      @Nullable String fileSystemPath,
      @Nullable String runtimeVersion,
      @Nullable String functionName) {
    this.fileSystemPath = fileSystemPath;
    this.runtimeVersion = runtimeVersion;
    this.functionName = functionName;
  }

  @Nullable
  @Override
  public String fileSystemPath() {
    return fileSystemPath;
  }

  @Nullable
  @Override
  public String runtimeVersion() {
    return runtimeVersion;
  }

  @Nullable
  @Override
  public String functionName() {
    return functionName;
  }

  @Override
  public String toString() {
    return "SubprocessRuntime{"
        + "fileSystemPath=" + fileSystemPath + ", "
        + "runtimeVersion=" + runtimeVersion + ", "
        + "functionName=" + functionName
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SubprocessTextTransformer.SubprocessRuntime) {
      SubprocessTextTransformer.SubprocessRuntime that = (SubprocessTextTransformer.SubprocessRuntime) o;
      return (this.fileSystemPath == null ? that.fileSystemPath() == null : this.fileSystemPath.equals(that.fileSystemPath()))
          && (this.runtimeVersion == null ? that.runtimeVersion() == null : this.runtimeVersion.equals(that.runtimeVersion()))
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
    h$ ^= (runtimeVersion == null) ? 0 : runtimeVersion.hashCode();
    h$ *= 1000003;
    h$ ^= (functionName == null) ? 0 : functionName.hashCode();
    return h$;
  }

  static final class Builder extends SubprocessTextTransformer.SubprocessRuntime.Builder {
    private String fileSystemPath;
    private String runtimeVersion;
    private String functionName;
    Builder() {
    }
    @Override
    public SubprocessTextTransformer.SubprocessRuntime.Builder setFileSystemPath(@Nullable String fileSystemPath) {
      this.fileSystemPath = fileSystemPath;
      return this;
    }
    @Override
    public SubprocessTextTransformer.SubprocessRuntime.Builder setRuntimeVersion(@Nullable String runtimeVersion) {
      this.runtimeVersion = runtimeVersion;
      return this;
    }
    @Override
    public SubprocessTextTransformer.SubprocessRuntime.Builder setFunctionName(@Nullable String functionName) {
      this.functionName = functionName;
      return this;
    }
    @Override
    public SubprocessTextTransformer.SubprocessRuntime build() {
      return new AutoValue_SubprocessTextTransformer_SubprocessRuntime(
          this.fileSystemPath,
          this.runtimeVersion,
          this.functionName);
    }
  }

}
