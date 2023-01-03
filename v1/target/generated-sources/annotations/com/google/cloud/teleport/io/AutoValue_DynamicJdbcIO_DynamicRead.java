package com.google.cloud.teleport.io;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.io.jdbc.JdbcIO;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_DynamicJdbcIO_DynamicRead<T> extends DynamicJdbcIO.DynamicRead<T> {

  private final DynamicJdbcIO.DynamicDataSourceConfiguration dynamicDataSourceConfiguration;

  private final ValueProvider<String> query;

  private final JdbcIO.RowMapper<T> rowMapper;

  private final Coder<T> coder;

  private AutoValue_DynamicJdbcIO_DynamicRead(
      @Nullable DynamicJdbcIO.DynamicDataSourceConfiguration dynamicDataSourceConfiguration,
      @Nullable ValueProvider<String> query,
      @Nullable JdbcIO.RowMapper<T> rowMapper,
      @Nullable Coder<T> coder) {
    this.dynamicDataSourceConfiguration = dynamicDataSourceConfiguration;
    this.query = query;
    this.rowMapper = rowMapper;
    this.coder = coder;
  }

  @Nullable
  @Override
  DynamicJdbcIO.DynamicDataSourceConfiguration getDynamicDataSourceConfiguration() {
    return dynamicDataSourceConfiguration;
  }

  @Nullable
  @Override
  ValueProvider<String> getQuery() {
    return query;
  }

  @Nullable
  @Override
  JdbcIO.RowMapper<T> getRowMapper() {
    return rowMapper;
  }

  @Nullable
  @Override
  Coder<T> getCoder() {
    return coder;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DynamicJdbcIO.DynamicRead) {
      DynamicJdbcIO.DynamicRead<?> that = (DynamicJdbcIO.DynamicRead<?>) o;
      return (this.dynamicDataSourceConfiguration == null ? that.getDynamicDataSourceConfiguration() == null : this.dynamicDataSourceConfiguration.equals(that.getDynamicDataSourceConfiguration()))
          && (this.query == null ? that.getQuery() == null : this.query.equals(that.getQuery()))
          && (this.rowMapper == null ? that.getRowMapper() == null : this.rowMapper.equals(that.getRowMapper()))
          && (this.coder == null ? that.getCoder() == null : this.coder.equals(that.getCoder()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (dynamicDataSourceConfiguration == null) ? 0 : dynamicDataSourceConfiguration.hashCode();
    h$ *= 1000003;
    h$ ^= (query == null) ? 0 : query.hashCode();
    h$ *= 1000003;
    h$ ^= (rowMapper == null) ? 0 : rowMapper.hashCode();
    h$ *= 1000003;
    h$ ^= (coder == null) ? 0 : coder.hashCode();
    return h$;
  }

  @Override
  DynamicJdbcIO.DynamicRead.Builder<T> toBuilder() {
    return new Builder<T>(this);
  }

  static final class Builder<T> extends DynamicJdbcIO.DynamicRead.Builder<T> {
    private DynamicJdbcIO.DynamicDataSourceConfiguration dynamicDataSourceConfiguration;
    private ValueProvider<String> query;
    private JdbcIO.RowMapper<T> rowMapper;
    private Coder<T> coder;
    Builder() {
    }
    private Builder(DynamicJdbcIO.DynamicRead<T> source) {
      this.dynamicDataSourceConfiguration = source.getDynamicDataSourceConfiguration();
      this.query = source.getQuery();
      this.rowMapper = source.getRowMapper();
      this.coder = source.getCoder();
    }
    @Override
    DynamicJdbcIO.DynamicRead.Builder<T> setDynamicDataSourceConfiguration(DynamicJdbcIO.DynamicDataSourceConfiguration dynamicDataSourceConfiguration) {
      this.dynamicDataSourceConfiguration = dynamicDataSourceConfiguration;
      return this;
    }
    @Override
    DynamicJdbcIO.DynamicRead.Builder<T> setQuery(ValueProvider<String> query) {
      this.query = query;
      return this;
    }
    @Override
    DynamicJdbcIO.DynamicRead.Builder<T> setRowMapper(JdbcIO.RowMapper<T> rowMapper) {
      this.rowMapper = rowMapper;
      return this;
    }
    @Override
    DynamicJdbcIO.DynamicRead.Builder<T> setCoder(Coder<T> coder) {
      this.coder = coder;
      return this;
    }
    @Override
    DynamicJdbcIO.DynamicRead<T> build() {
      return new AutoValue_DynamicJdbcIO_DynamicRead<T>(
          this.dynamicDataSourceConfiguration,
          this.query,
          this.rowMapper,
          this.coder);
    }
  }

}
