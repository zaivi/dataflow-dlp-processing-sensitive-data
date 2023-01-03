package com.google.cloud.teleport.it.dataflow;

import java.time.Duration;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DataflowOperator_Config extends DataflowOperator.Config {

  private final String project;

  private final String jobId;

  private final String region;

  private final Duration checkAfter;

  private final Duration timeoutAfter;

  private AutoValue_DataflowOperator_Config(
      String project,
      String jobId,
      String region,
      Duration checkAfter,
      Duration timeoutAfter) {
    this.project = project;
    this.jobId = jobId;
    this.region = region;
    this.checkAfter = checkAfter;
    this.timeoutAfter = timeoutAfter;
  }

  @Override
  public String project() {
    return project;
  }

  @Override
  public String jobId() {
    return jobId;
  }

  @Override
  public String region() {
    return region;
  }

  @Override
  public Duration checkAfter() {
    return checkAfter;
  }

  @Override
  public Duration timeoutAfter() {
    return timeoutAfter;
  }

  @Override
  public String toString() {
    return "Config{"
        + "project=" + project + ", "
        + "jobId=" + jobId + ", "
        + "region=" + region + ", "
        + "checkAfter=" + checkAfter + ", "
        + "timeoutAfter=" + timeoutAfter
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DataflowOperator.Config) {
      DataflowOperator.Config that = (DataflowOperator.Config) o;
      return this.project.equals(that.project())
          && this.jobId.equals(that.jobId())
          && this.region.equals(that.region())
          && this.checkAfter.equals(that.checkAfter())
          && this.timeoutAfter.equals(that.timeoutAfter());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= project.hashCode();
    h$ *= 1000003;
    h$ ^= jobId.hashCode();
    h$ *= 1000003;
    h$ ^= region.hashCode();
    h$ *= 1000003;
    h$ ^= checkAfter.hashCode();
    h$ *= 1000003;
    h$ ^= timeoutAfter.hashCode();
    return h$;
  }

  static final class Builder extends DataflowOperator.Config.Builder {
    private String project;
    private String jobId;
    private String region;
    private Duration checkAfter;
    private Duration timeoutAfter;
    Builder() {
    }
    @Override
    public DataflowOperator.Config.Builder setProject(String project) {
      if (project == null) {
        throw new NullPointerException("Null project");
      }
      this.project = project;
      return this;
    }
    @Override
    public DataflowOperator.Config.Builder setJobId(String jobId) {
      if (jobId == null) {
        throw new NullPointerException("Null jobId");
      }
      this.jobId = jobId;
      return this;
    }
    @Override
    public DataflowOperator.Config.Builder setRegion(String region) {
      if (region == null) {
        throw new NullPointerException("Null region");
      }
      this.region = region;
      return this;
    }
    @Override
    public DataflowOperator.Config.Builder setCheckAfter(Duration checkAfter) {
      if (checkAfter == null) {
        throw new NullPointerException("Null checkAfter");
      }
      this.checkAfter = checkAfter;
      return this;
    }
    @Override
    public DataflowOperator.Config.Builder setTimeoutAfter(Duration timeoutAfter) {
      if (timeoutAfter == null) {
        throw new NullPointerException("Null timeoutAfter");
      }
      this.timeoutAfter = timeoutAfter;
      return this;
    }
    @Override
    DataflowOperator.Config autoBuild() {
      if (this.project == null
          || this.jobId == null
          || this.region == null
          || this.checkAfter == null
          || this.timeoutAfter == null) {
        StringBuilder missing = new StringBuilder();
        if (this.project == null) {
          missing.append(" project");
        }
        if (this.jobId == null) {
          missing.append(" jobId");
        }
        if (this.region == null) {
          missing.append(" region");
        }
        if (this.checkAfter == null) {
          missing.append(" checkAfter");
        }
        if (this.timeoutAfter == null) {
          missing.append(" timeoutAfter");
        }
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_DataflowOperator_Config(
          this.project,
          this.jobId,
          this.region,
          this.checkAfter,
          this.timeoutAfter);
    }
  }

}
