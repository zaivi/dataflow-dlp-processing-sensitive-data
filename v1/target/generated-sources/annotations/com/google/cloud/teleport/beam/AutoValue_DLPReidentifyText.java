package com.google.cloud.teleport.beam;

import com.google.privacy.dlp.v2.DeidentifyConfig;
import com.google.privacy.dlp.v2.InspectConfig;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.beam.sdk.values.PCollectionView;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DLPReidentifyText extends DLPReidentifyText {

  private final ValueProvider<String> inspectTemplateName;

  private final ValueProvider<String> reidentifyTemplateName;

  private final InspectConfig inspectConfig;

  private final DeidentifyConfig reidentifyConfig;

  private final ValueProvider<Character> columnDelimiter;

  private final PCollectionView<Map<String, List<String>>> headerColumns;

  private final ValueProvider<Integer> batchSizeBytes;

  private final String projectId;

  private AutoValue_DLPReidentifyText(
      @Nullable ValueProvider<String> inspectTemplateName,
      @Nullable ValueProvider<String> reidentifyTemplateName,
      @Nullable InspectConfig inspectConfig,
      @Nullable DeidentifyConfig reidentifyConfig,
      @Nullable ValueProvider<Character> columnDelimiter,
      @Nullable PCollectionView<Map<String, List<String>>> headerColumns,
      ValueProvider<Integer> batchSizeBytes,
      String projectId) {
    this.inspectTemplateName = inspectTemplateName;
    this.reidentifyTemplateName = reidentifyTemplateName;
    this.inspectConfig = inspectConfig;
    this.reidentifyConfig = reidentifyConfig;
    this.columnDelimiter = columnDelimiter;
    this.headerColumns = headerColumns;
    this.batchSizeBytes = batchSizeBytes;
    this.projectId = projectId;
  }

  @Nullable
  @Override
  public ValueProvider<String> getInspectTemplateName() {
    return inspectTemplateName;
  }

  @Nullable
  @Override
  public ValueProvider<String> getReidentifyTemplateName() {
    return reidentifyTemplateName;
  }

  @Nullable
  @Override
  public InspectConfig getInspectConfig() {
    return inspectConfig;
  }

  @Nullable
  @Override
  public DeidentifyConfig getReidentifyConfig() {
    return reidentifyConfig;
  }

  @Nullable
  @Override
  public ValueProvider<Character> getColumnDelimiter() {
    return columnDelimiter;
  }

  @Nullable
  @Override
  public PCollectionView<Map<String, List<String>>> getHeaderColumns() {
    return headerColumns;
  }

  @Override
  public ValueProvider<Integer> getBatchSizeBytes() {
    return batchSizeBytes;
  }

  @Override
  public String getProjectId() {
    return projectId;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DLPReidentifyText) {
      DLPReidentifyText that = (DLPReidentifyText) o;
      return (this.inspectTemplateName == null ? that.getInspectTemplateName() == null : this.inspectTemplateName.equals(that.getInspectTemplateName()))
          && (this.reidentifyTemplateName == null ? that.getReidentifyTemplateName() == null : this.reidentifyTemplateName.equals(that.getReidentifyTemplateName()))
          && (this.inspectConfig == null ? that.getInspectConfig() == null : this.inspectConfig.equals(that.getInspectConfig()))
          && (this.reidentifyConfig == null ? that.getReidentifyConfig() == null : this.reidentifyConfig.equals(that.getReidentifyConfig()))
          && (this.columnDelimiter == null ? that.getColumnDelimiter() == null : this.columnDelimiter.equals(that.getColumnDelimiter()))
          && (this.headerColumns == null ? that.getHeaderColumns() == null : this.headerColumns.equals(that.getHeaderColumns()))
          && this.batchSizeBytes.equals(that.getBatchSizeBytes())
          && this.projectId.equals(that.getProjectId());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (inspectTemplateName == null) ? 0 : inspectTemplateName.hashCode();
    h$ *= 1000003;
    h$ ^= (reidentifyTemplateName == null) ? 0 : reidentifyTemplateName.hashCode();
    h$ *= 1000003;
    h$ ^= (inspectConfig == null) ? 0 : inspectConfig.hashCode();
    h$ *= 1000003;
    h$ ^= (reidentifyConfig == null) ? 0 : reidentifyConfig.hashCode();
    h$ *= 1000003;
    h$ ^= (columnDelimiter == null) ? 0 : columnDelimiter.hashCode();
    h$ *= 1000003;
    h$ ^= (headerColumns == null) ? 0 : headerColumns.hashCode();
    h$ *= 1000003;
    h$ ^= batchSizeBytes.hashCode();
    h$ *= 1000003;
    h$ ^= projectId.hashCode();
    return h$;
  }

  static final class Builder extends DLPReidentifyText.Builder {
    private ValueProvider<String> inspectTemplateName;
    private ValueProvider<String> reidentifyTemplateName;
    private InspectConfig inspectConfig;
    private DeidentifyConfig reidentifyConfig;
    private ValueProvider<Character> columnDelimiter;
    private PCollectionView<Map<String, List<String>>> headerColumns;
    private ValueProvider<Integer> batchSizeBytes;
    private String projectId;
    Builder() {
    }
    @Override
    public DLPReidentifyText.Builder setInspectTemplateName(ValueProvider<String> inspectTemplateName) {
      this.inspectTemplateName = inspectTemplateName;
      return this;
    }
    @Override
    public DLPReidentifyText.Builder setReidentifyTemplateName(ValueProvider<String> reidentifyTemplateName) {
      this.reidentifyTemplateName = reidentifyTemplateName;
      return this;
    }
    @Override
    public DLPReidentifyText.Builder setInspectConfig(InspectConfig inspectConfig) {
      this.inspectConfig = inspectConfig;
      return this;
    }
    @Override
    public DLPReidentifyText.Builder setReidentifyConfig(DeidentifyConfig reidentifyConfig) {
      this.reidentifyConfig = reidentifyConfig;
      return this;
    }
    @Override
    public DLPReidentifyText.Builder setColumnDelimiter(ValueProvider<Character> columnDelimiter) {
      this.columnDelimiter = columnDelimiter;
      return this;
    }
    @Override
    public DLPReidentifyText.Builder setHeaderColumns(PCollectionView<Map<String, List<String>>> headerColumns) {
      this.headerColumns = headerColumns;
      return this;
    }
    @Override
    public DLPReidentifyText.Builder setBatchSizeBytes(ValueProvider<Integer> batchSizeBytes) {
      if (batchSizeBytes == null) {
        throw new NullPointerException("Null batchSizeBytes");
      }
      this.batchSizeBytes = batchSizeBytes;
      return this;
    }
    @Override
    public DLPReidentifyText.Builder setProjectId(String projectId) {
      if (projectId == null) {
        throw new NullPointerException("Null projectId");
      }
      this.projectId = projectId;
      return this;
    }
    @Override
    public DLPReidentifyText build() {
      String missing = "";
      if (this.batchSizeBytes == null) {
        missing += " batchSizeBytes";
      }
      if (this.projectId == null) {
        missing += " projectId";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_DLPReidentifyText(
          this.inspectTemplateName,
          this.reidentifyTemplateName,
          this.inspectConfig,
          this.reidentifyConfig,
          this.columnDelimiter,
          this.headerColumns,
          this.batchSizeBytes,
          this.projectId);
    }
  }

}
