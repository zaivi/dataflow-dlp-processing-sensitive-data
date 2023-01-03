package com.google.cloud.teleport.templates.common;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SubprocessTextTransformer_TransformTextViaSubprocess extends SubprocessTextTransformer.TransformTextViaSubprocess {

  private final ValueProvider<String> fileSystemPath;

  private final ValueProvider<String> runtimeVersion;

  private final ValueProvider<String> functionName;

  private AutoValue_SubprocessTextTransformer_TransformTextViaSubprocess(
      @Nullable ValueProvider<String> fileSystemPath,
      @Nullable ValueProvider<String> runtimeVersion,
      @Nullable ValueProvider<String> functionName) {
    this.fileSystemPath = fileSystemPath;
    this.runtimeVersion = runtimeVersion;
    this.functionName = functionName;
  }

  @Nullable
  @Override
  public ValueProvider<String> fileSystemPath() {
    return fileSystemPath;
  }

  @Nullable
  @Override
  public ValueProvider<String> runtimeVersion() {
    return runtimeVersion;
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
    if (o instanceof SubprocessTextTransformer.TransformTextViaSubprocess) {
      SubprocessTextTransformer.TransformTextViaSubprocess that = (SubprocessTextTransformer.TransformTextViaSubprocess) o;
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

  static final class Builder extends SubprocessTextTransformer.TransformTextViaSubprocess.Builder {
    private ValueProvider<String> fileSystemPath;
    private ValueProvider<String> runtimeVersion;
    private ValueProvider<String> functionName;
    Builder() {
    }
    @Override
    public SubprocessTextTransformer.TransformTextViaSubprocess.Builder setFileSystemPath(@Nullable ValueProvider<String> fileSystemPath) {
      this.fileSystemPath = fileSystemPath;
      return this;
    }
    @Override
    public SubprocessTextTransformer.TransformTextViaSubprocess.Builder setRuntimeVersion(@Nullable ValueProvider<String> runtimeVersion) {
      this.runtimeVersion = runtimeVersion;
      return this;
    }
    @Override
    public SubprocessTextTransformer.TransformTextViaSubprocess.Builder setFunctionName(@Nullable ValueProvider<String> functionName) {
      this.functionName = functionName;
      return this;
    }
    @Override
    public SubprocessTextTransformer.TransformTextViaSubprocess build() {
      return new AutoValue_SubprocessTextTransformer_TransformTextViaSubprocess(
          this.fileSystemPath,
          this.runtimeVersion,
          this.functionName);
    }
  }

}
