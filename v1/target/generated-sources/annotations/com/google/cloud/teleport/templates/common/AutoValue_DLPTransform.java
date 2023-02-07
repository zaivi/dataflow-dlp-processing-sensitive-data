package com.google.cloud.teleport.templates.common;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.beam.sdk.values.PCollectionView;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DLPTransform extends DLPTransform {

  private final ValueProvider<String> deidTemplateName;

  private final ValueProvider<Integer> batchSize;

  private final String projectId;

  private final ValueProvider<Character> columnDelimiter;

  private final String jobName;

  private final PCollectionView<Map<String, List<String>>> headers;

  private AutoValue_DLPTransform(
      @Nullable ValueProvider<String> deidTemplateName,
      ValueProvider<Integer> batchSize,
      String projectId,
      ValueProvider<Character> columnDelimiter,
      String jobName,
      PCollectionView<Map<String, List<String>>> headers) {
    this.deidTemplateName = deidTemplateName;
    this.batchSize = batchSize;
    this.projectId = projectId;
    this.columnDelimiter = columnDelimiter;
    this.jobName = jobName;
    this.headers = headers;
  }

  @Nullable
  @Override
  public ValueProvider<String> deidTemplateName() {
    return deidTemplateName;
  }

  @Override
  ValueProvider<Integer> batchSize() {
    return batchSize;
  }

  @Override
  public String projectId() {
    return projectId;
  }

  @Override
  public ValueProvider<Character> columnDelimiter() {
    return columnDelimiter;
  }

  @Override
  public String jobName() {
    return jobName;
  }

  @Override
  public PCollectionView<Map<String, List<String>>> headers() {
    return headers;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DLPTransform) {
      DLPTransform that = (DLPTransform) o;
      return (this.deidTemplateName == null ? that.deidTemplateName() == null : this.deidTemplateName.equals(that.deidTemplateName()))
          && this.batchSize.equals(that.batchSize())
          && this.projectId.equals(that.projectId())
          && this.columnDelimiter.equals(that.columnDelimiter())
          && this.jobName.equals(that.jobName())
          && this.headers.equals(that.headers());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (deidTemplateName == null) ? 0 : deidTemplateName.hashCode();
    h$ *= 1000003;
    h$ ^= batchSize.hashCode();
    h$ *= 1000003;
    h$ ^= projectId.hashCode();
    h$ *= 1000003;
    h$ ^= columnDelimiter.hashCode();
    h$ *= 1000003;
    h$ ^= jobName.hashCode();
    h$ *= 1000003;
    h$ ^= headers.hashCode();
    return h$;
  }

  static final class Builder extends DLPTransform.Builder {
    private ValueProvider<String> deidTemplateName;
    private ValueProvider<Integer> batchSize;
    private String projectId;
    private ValueProvider<Character> columnDelimiter;
    private String jobName;
    private PCollectionView<Map<String, List<String>>> headers;
    Builder() {
    }
    @Override
    public DLPTransform.Builder setDeidTemplateName(ValueProvider<String> deidTemplateName) {
      this.deidTemplateName = deidTemplateName;
      return this;
    }
    @Override
    public DLPTransform.Builder setBatchSize(ValueProvider<Integer> batchSize) {
      if (batchSize == null) {
        throw new NullPointerException("Null batchSize");
      }
      this.batchSize = batchSize;
      return this;
    }
    @Override
    public DLPTransform.Builder setProjectId(String projectId) {
      if (projectId == null) {
        throw new NullPointerException("Null projectId");
      }
      this.projectId = projectId;
      return this;
    }
    @Override
    public DLPTransform.Builder setColumnDelimiter(ValueProvider<Character> columnDelimiter) {
      if (columnDelimiter == null) {
        throw new NullPointerException("Null columnDelimiter");
      }
      this.columnDelimiter = columnDelimiter;
      return this;
    }
    @Override
    public DLPTransform.Builder setJobName(String jobName) {
      if (jobName == null) {
        throw new NullPointerException("Null jobName");
      }
      this.jobName = jobName;
      return this;
    }
    @Override
    public DLPTransform.Builder setHeaders(PCollectionView<Map<String, List<String>>> headers) {
      if (headers == null) {
        throw new NullPointerException("Null headers");
      }
      this.headers = headers;
      return this;
    }
    @Override
    public DLPTransform build() {
      String missing = "";
      if (this.batchSize == null) {
        missing += " batchSize";
      }
      if (this.projectId == null) {
        missing += " projectId";
      }
      if (this.columnDelimiter == null) {
        missing += " columnDelimiter";
      }
      if (this.jobName == null) {
        missing += " jobName";
      }
      if (this.headers == null) {
        missing += " headers";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_DLPTransform(
          this.deidTemplateName,
          this.batchSize,
          this.projectId,
          this.columnDelimiter,
          this.jobName,
          this.headers);
    }
  }

}
