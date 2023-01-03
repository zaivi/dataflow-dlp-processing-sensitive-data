package com.google.cloud.teleport.templates;

import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_PubsubToPubsub_ExtractAndFilterEventsFn extends PubsubToPubsub.ExtractAndFilterEventsFn {

  private final ValueProvider<String> filterKey;

  private final ValueProvider<String> filterValue;

  private AutoValue_PubsubToPubsub_ExtractAndFilterEventsFn(
      @Nullable ValueProvider<String> filterKey,
      @Nullable ValueProvider<String> filterValue) {
    this.filterKey = filterKey;
    this.filterValue = filterValue;
  }

  @Nullable
  @Override
  ValueProvider<String> filterKey() {
    return filterKey;
  }

  @Nullable
  @Override
  ValueProvider<String> filterValue() {
    return filterValue;
  }

  @Override
  public String toString() {
    return "ExtractAndFilterEventsFn{"
        + "filterKey=" + filterKey + ", "
        + "filterValue=" + filterValue
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PubsubToPubsub.ExtractAndFilterEventsFn) {
      PubsubToPubsub.ExtractAndFilterEventsFn that = (PubsubToPubsub.ExtractAndFilterEventsFn) o;
      return (this.filterKey == null ? that.filterKey() == null : this.filterKey.equals(that.filterKey()))
          && (this.filterValue == null ? that.filterValue() == null : this.filterValue.equals(that.filterValue()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (filterKey == null) ? 0 : filterKey.hashCode();
    h$ *= 1000003;
    h$ ^= (filterValue == null) ? 0 : filterValue.hashCode();
    return h$;
  }

  static final class Builder extends PubsubToPubsub.ExtractAndFilterEventsFn.Builder {
    private ValueProvider<String> filterKey;
    private ValueProvider<String> filterValue;
    Builder() {
    }
    @Override
    PubsubToPubsub.ExtractAndFilterEventsFn.Builder setFilterKey(ValueProvider<String> filterKey) {
      this.filterKey = filterKey;
      return this;
    }
    @Override
    PubsubToPubsub.ExtractAndFilterEventsFn.Builder setFilterValue(ValueProvider<String> filterValue) {
      this.filterValue = filterValue;
      return this;
    }
    @Override
    PubsubToPubsub.ExtractAndFilterEventsFn build() {
      return new AutoValue_PubsubToPubsub_ExtractAndFilterEventsFn(
          this.filterKey,
          this.filterValue);
    }
  }

}
