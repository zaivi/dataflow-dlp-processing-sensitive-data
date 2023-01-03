package com.google.cloud.teleport.splunk;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SplunkEvent extends SplunkEvent {

  private final Long time;

  private final String host;

  private final String source;

  private final String sourceType;

  private final String index;

  private final JsonObject fields;

  private final String event;

  private AutoValue_SplunkEvent(
      @Nullable Long time,
      @Nullable String host,
      @Nullable String source,
      @Nullable String sourceType,
      @Nullable String index,
      @Nullable JsonObject fields,
      @Nullable String event) {
    this.time = time;
    this.host = host;
    this.source = source;
    this.sourceType = sourceType;
    this.index = index;
    this.fields = fields;
    this.event = event;
  }

  @Nullable
  @Override
  public Long time() {
    return time;
  }

  @Nullable
  @Override
  public String host() {
    return host;
  }

  @Nullable
  @Override
  public String source() {
    return source;
  }

  @Nullable
  @SerializedName("sourcetype")
  @Override
  public String sourceType() {
    return sourceType;
  }

  @Nullable
  @Override
  public String index() {
    return index;
  }

  @Nullable
  @Override
  public JsonObject fields() {
    return fields;
  }

  @Nullable
  @Override
  public String event() {
    return event;
  }

  @Override
  public String toString() {
    return "SplunkEvent{"
        + "time=" + time + ", "
        + "host=" + host + ", "
        + "source=" + source + ", "
        + "sourceType=" + sourceType + ", "
        + "index=" + index + ", "
        + "fields=" + fields + ", "
        + "event=" + event
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SplunkEvent) {
      SplunkEvent that = (SplunkEvent) o;
      return (this.time == null ? that.time() == null : this.time.equals(that.time()))
          && (this.host == null ? that.host() == null : this.host.equals(that.host()))
          && (this.source == null ? that.source() == null : this.source.equals(that.source()))
          && (this.sourceType == null ? that.sourceType() == null : this.sourceType.equals(that.sourceType()))
          && (this.index == null ? that.index() == null : this.index.equals(that.index()))
          && (this.fields == null ? that.fields() == null : this.fields.equals(that.fields()))
          && (this.event == null ? that.event() == null : this.event.equals(that.event()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (time == null) ? 0 : time.hashCode();
    h$ *= 1000003;
    h$ ^= (host == null) ? 0 : host.hashCode();
    h$ *= 1000003;
    h$ ^= (source == null) ? 0 : source.hashCode();
    h$ *= 1000003;
    h$ ^= (sourceType == null) ? 0 : sourceType.hashCode();
    h$ *= 1000003;
    h$ ^= (index == null) ? 0 : index.hashCode();
    h$ *= 1000003;
    h$ ^= (fields == null) ? 0 : fields.hashCode();
    h$ *= 1000003;
    h$ ^= (event == null) ? 0 : event.hashCode();
    return h$;
  }

  static final class Builder extends SplunkEvent.Builder {
    private Long time;
    private String host;
    private String source;
    private String sourceType;
    private String index;
    private JsonObject fields;
    private String event;
    Builder() {
    }
    @Override
    SplunkEvent.Builder setTime(Long time) {
      this.time = time;
      return this;
    }
    @Override
    SplunkEvent.Builder setHost(String host) {
      this.host = host;
      return this;
    }
    @Override
    SplunkEvent.Builder setSource(String source) {
      this.source = source;
      return this;
    }
    @Override
    SplunkEvent.Builder setSourceType(String sourceType) {
      this.sourceType = sourceType;
      return this;
    }
    @Override
    SplunkEvent.Builder setIndex(String index) {
      this.index = index;
      return this;
    }
    @Override
    SplunkEvent.Builder setFields(JsonObject fields) {
      this.fields = fields;
      return this;
    }
    @Override
    SplunkEvent.Builder setEvent(String event) {
      this.event = event;
      return this;
    }
    @Override
    @Nullable String event() {
      return event;
    }
    @Override
    SplunkEvent autoBuild() {
      return new AutoValue_SplunkEvent(
          this.time,
          this.host,
          this.source,
          this.sourceType,
          this.index,
          this.fields,
          this.event);
    }
  }

}
