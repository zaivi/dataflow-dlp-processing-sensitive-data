package com.google.cloud.teleport.it.dataflow;

import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DataflowClient_JobInfo extends DataflowClient.JobInfo {

  private final String jobId;

  private final DataflowClient.JobState state;

  private final String createTime;

  private final String sdk;

  private final String version;

  private final String jobType;

  private final String runner;

  private final String templateName;

  private final String templateType;

  private final String templateVersion;

  private final ImmutableMap<String, String> parameters;

  private AutoValue_DataflowClient_JobInfo(
      String jobId,
      DataflowClient.JobState state,
      String createTime,
      String sdk,
      String version,
      String jobType,
      String runner,
      @Nullable String templateName,
      @Nullable String templateType,
      @Nullable String templateVersion,
      ImmutableMap<String, String> parameters) {
    this.jobId = jobId;
    this.state = state;
    this.createTime = createTime;
    this.sdk = sdk;
    this.version = version;
    this.jobType = jobType;
    this.runner = runner;
    this.templateName = templateName;
    this.templateType = templateType;
    this.templateVersion = templateVersion;
    this.parameters = parameters;
  }

  @Override
  public String jobId() {
    return jobId;
  }

  @Override
  public DataflowClient.JobState state() {
    return state;
  }

  @Override
  public String createTime() {
    return createTime;
  }

  @Override
  public String sdk() {
    return sdk;
  }

  @Override
  public String version() {
    return version;
  }

  @Override
  public String jobType() {
    return jobType;
  }

  @Override
  public String runner() {
    return runner;
  }

  @Nullable
  @Override
  public String templateName() {
    return templateName;
  }

  @Nullable
  @Override
  public String templateType() {
    return templateType;
  }

  @Nullable
  @Override
  public String templateVersion() {
    return templateVersion;
  }

  @Override
  public ImmutableMap<String, String> parameters() {
    return parameters;
  }

  @Override
  public String toString() {
    return "JobInfo{"
        + "jobId=" + jobId + ", "
        + "state=" + state + ", "
        + "createTime=" + createTime + ", "
        + "sdk=" + sdk + ", "
        + "version=" + version + ", "
        + "jobType=" + jobType + ", "
        + "runner=" + runner + ", "
        + "templateName=" + templateName + ", "
        + "templateType=" + templateType + ", "
        + "templateVersion=" + templateVersion + ", "
        + "parameters=" + parameters
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DataflowClient.JobInfo) {
      DataflowClient.JobInfo that = (DataflowClient.JobInfo) o;
      return this.jobId.equals(that.jobId())
          && this.state.equals(that.state())
          && this.createTime.equals(that.createTime())
          && this.sdk.equals(that.sdk())
          && this.version.equals(that.version())
          && this.jobType.equals(that.jobType())
          && this.runner.equals(that.runner())
          && (this.templateName == null ? that.templateName() == null : this.templateName.equals(that.templateName()))
          && (this.templateType == null ? that.templateType() == null : this.templateType.equals(that.templateType()))
          && (this.templateVersion == null ? that.templateVersion() == null : this.templateVersion.equals(that.templateVersion()))
          && this.parameters.equals(that.parameters());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= jobId.hashCode();
    h$ *= 1000003;
    h$ ^= state.hashCode();
    h$ *= 1000003;
    h$ ^= createTime.hashCode();
    h$ *= 1000003;
    h$ ^= sdk.hashCode();
    h$ *= 1000003;
    h$ ^= version.hashCode();
    h$ *= 1000003;
    h$ ^= jobType.hashCode();
    h$ *= 1000003;
    h$ ^= runner.hashCode();
    h$ *= 1000003;
    h$ ^= (templateName == null) ? 0 : templateName.hashCode();
    h$ *= 1000003;
    h$ ^= (templateType == null) ? 0 : templateType.hashCode();
    h$ *= 1000003;
    h$ ^= (templateVersion == null) ? 0 : templateVersion.hashCode();
    h$ *= 1000003;
    h$ ^= parameters.hashCode();
    return h$;
  }

  static final class Builder extends DataflowClient.JobInfo.Builder {
    private String jobId;
    private DataflowClient.JobState state;
    private String createTime;
    private String sdk;
    private String version;
    private String jobType;
    private String runner;
    private String templateName;
    private String templateType;
    private String templateVersion;
    private ImmutableMap<String, String> parameters;
    Builder() {
    }
    @Override
    public DataflowClient.JobInfo.Builder setJobId(String jobId) {
      if (jobId == null) {
        throw new NullPointerException("Null jobId");
      }
      this.jobId = jobId;
      return this;
    }
    @Override
    public DataflowClient.JobInfo.Builder setState(DataflowClient.JobState state) {
      if (state == null) {
        throw new NullPointerException("Null state");
      }
      this.state = state;
      return this;
    }
    @Override
    public DataflowClient.JobInfo.Builder setCreateTime(String createTime) {
      if (createTime == null) {
        throw new NullPointerException("Null createTime");
      }
      this.createTime = createTime;
      return this;
    }
    @Override
    public DataflowClient.JobInfo.Builder setSdk(String sdk) {
      if (sdk == null) {
        throw new NullPointerException("Null sdk");
      }
      this.sdk = sdk;
      return this;
    }
    @Override
    public DataflowClient.JobInfo.Builder setVersion(String version) {
      if (version == null) {
        throw new NullPointerException("Null version");
      }
      this.version = version;
      return this;
    }
    @Override
    public DataflowClient.JobInfo.Builder setJobType(String jobType) {
      if (jobType == null) {
        throw new NullPointerException("Null jobType");
      }
      this.jobType = jobType;
      return this;
    }
    @Override
    public DataflowClient.JobInfo.Builder setRunner(String runner) {
      if (runner == null) {
        throw new NullPointerException("Null runner");
      }
      this.runner = runner;
      return this;
    }
    @Override
    public DataflowClient.JobInfo.Builder setTemplateName(String templateName) {
      this.templateName = templateName;
      return this;
    }
    @Override
    public DataflowClient.JobInfo.Builder setTemplateType(String templateType) {
      this.templateType = templateType;
      return this;
    }
    @Override
    public DataflowClient.JobInfo.Builder setTemplateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }
    @Override
    public DataflowClient.JobInfo.Builder setParameters(ImmutableMap<String, String> parameters) {
      if (parameters == null) {
        throw new NullPointerException("Null parameters");
      }
      this.parameters = parameters;
      return this;
    }
    @Override
    public DataflowClient.JobInfo build() {
      if (this.jobId == null
          || this.state == null
          || this.createTime == null
          || this.sdk == null
          || this.version == null
          || this.jobType == null
          || this.runner == null
          || this.parameters == null) {
        StringBuilder missing = new StringBuilder();
        if (this.jobId == null) {
          missing.append(" jobId");
        }
        if (this.state == null) {
          missing.append(" state");
        }
        if (this.createTime == null) {
          missing.append(" createTime");
        }
        if (this.sdk == null) {
          missing.append(" sdk");
        }
        if (this.version == null) {
          missing.append(" version");
        }
        if (this.jobType == null) {
          missing.append(" jobType");
        }
        if (this.runner == null) {
          missing.append(" runner");
        }
        if (this.parameters == null) {
          missing.append(" parameters");
        }
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_DataflowClient_JobInfo(
          this.jobId,
          this.state,
          this.createTime,
          this.sdk,
          this.version,
          this.jobType,
          this.runner,
          this.templateName,
          this.templateType,
          this.templateVersion,
          this.parameters);
    }
  }

}
