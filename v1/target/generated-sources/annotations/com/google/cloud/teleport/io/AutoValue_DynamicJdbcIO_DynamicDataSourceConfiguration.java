package com.google.cloud.teleport.io;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DynamicJdbcIO_DynamicDataSourceConfiguration extends DynamicJdbcIO.DynamicDataSourceConfiguration {

  private final ValueProvider<String> driverClassName;

  private final ValueProvider<String> url;

  private final ValueProvider<String> username;

  private final ValueProvider<String> password;

  private final ValueProvider<String> connectionProperties;

  private final ValueProvider<String> driverJars;

  private AutoValue_DynamicJdbcIO_DynamicDataSourceConfiguration(
      @Nullable ValueProvider<String> driverClassName,
      @Nullable ValueProvider<String> url,
      @Nullable ValueProvider<String> username,
      @Nullable ValueProvider<String> password,
      @Nullable ValueProvider<String> connectionProperties,
      @Nullable ValueProvider<String> driverJars) {
    this.driverClassName = driverClassName;
    this.url = url;
    this.username = username;
    this.password = password;
    this.connectionProperties = connectionProperties;
    this.driverJars = driverJars;
  }

  @Nullable
  @Override
  ValueProvider<String> getDriverClassName() {
    return driverClassName;
  }

  @Nullable
  @Override
  ValueProvider<String> getUrl() {
    return url;
  }

  @Nullable
  @Override
  ValueProvider<String> getUsername() {
    return username;
  }

  @Nullable
  @Override
  ValueProvider<String> getPassword() {
    return password;
  }

  @Nullable
  @Override
  ValueProvider<String> getConnectionProperties() {
    return connectionProperties;
  }

  @Nullable
  @Override
  ValueProvider<String> getDriverJars() {
    return driverJars;
  }

  @Override
  public String toString() {
    return "DynamicDataSourceConfiguration{"
        + "driverClassName=" + driverClassName + ", "
        + "url=" + url + ", "
        + "username=" + username + ", "
        + "password=" + password + ", "
        + "connectionProperties=" + connectionProperties + ", "
        + "driverJars=" + driverJars
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DynamicJdbcIO.DynamicDataSourceConfiguration) {
      DynamicJdbcIO.DynamicDataSourceConfiguration that = (DynamicJdbcIO.DynamicDataSourceConfiguration) o;
      return (this.driverClassName == null ? that.getDriverClassName() == null : this.driverClassName.equals(that.getDriverClassName()))
          && (this.url == null ? that.getUrl() == null : this.url.equals(that.getUrl()))
          && (this.username == null ? that.getUsername() == null : this.username.equals(that.getUsername()))
          && (this.password == null ? that.getPassword() == null : this.password.equals(that.getPassword()))
          && (this.connectionProperties == null ? that.getConnectionProperties() == null : this.connectionProperties.equals(that.getConnectionProperties()))
          && (this.driverJars == null ? that.getDriverJars() == null : this.driverJars.equals(that.getDriverJars()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (driverClassName == null) ? 0 : driverClassName.hashCode();
    h$ *= 1000003;
    h$ ^= (url == null) ? 0 : url.hashCode();
    h$ *= 1000003;
    h$ ^= (username == null) ? 0 : username.hashCode();
    h$ *= 1000003;
    h$ ^= (password == null) ? 0 : password.hashCode();
    h$ *= 1000003;
    h$ ^= (connectionProperties == null) ? 0 : connectionProperties.hashCode();
    h$ *= 1000003;
    h$ ^= (driverJars == null) ? 0 : driverJars.hashCode();
    return h$;
  }

  @Override
  DynamicJdbcIO.DynamicDataSourceConfiguration.Builder builder() {
    return new Builder(this);
  }

  static final class Builder extends DynamicJdbcIO.DynamicDataSourceConfiguration.Builder {
    private ValueProvider<String> driverClassName;
    private ValueProvider<String> url;
    private ValueProvider<String> username;
    private ValueProvider<String> password;
    private ValueProvider<String> connectionProperties;
    private ValueProvider<String> driverJars;
    Builder() {
    }
    private Builder(DynamicJdbcIO.DynamicDataSourceConfiguration source) {
      this.driverClassName = source.getDriverClassName();
      this.url = source.getUrl();
      this.username = source.getUsername();
      this.password = source.getPassword();
      this.connectionProperties = source.getConnectionProperties();
      this.driverJars = source.getDriverJars();
    }
    @Override
    DynamicJdbcIO.DynamicDataSourceConfiguration.Builder setDriverClassName(ValueProvider<String> driverClassName) {
      this.driverClassName = driverClassName;
      return this;
    }
    @Override
    DynamicJdbcIO.DynamicDataSourceConfiguration.Builder setUrl(ValueProvider<String> url) {
      this.url = url;
      return this;
    }
    @Override
    DynamicJdbcIO.DynamicDataSourceConfiguration.Builder setUsername(ValueProvider<String> username) {
      this.username = username;
      return this;
    }
    @Override
    DynamicJdbcIO.DynamicDataSourceConfiguration.Builder setPassword(ValueProvider<String> password) {
      this.password = password;
      return this;
    }
    @Override
    DynamicJdbcIO.DynamicDataSourceConfiguration.Builder setConnectionProperties(ValueProvider<String> connectionProperties) {
      this.connectionProperties = connectionProperties;
      return this;
    }
    @Override
    DynamicJdbcIO.DynamicDataSourceConfiguration.Builder setDriverJars(ValueProvider<String> driverJars) {
      this.driverJars = driverJars;
      return this;
    }
    @Override
    DynamicJdbcIO.DynamicDataSourceConfiguration build() {
      return new AutoValue_DynamicJdbcIO_DynamicDataSourceConfiguration(
          this.driverClassName,
          this.url,
          this.username,
          this.password,
          this.connectionProperties,
          this.driverJars);
    }
  }

}
