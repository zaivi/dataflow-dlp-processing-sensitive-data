package com.google.cloud.teleport.kafka.connector;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.beam.sdk.transforms.SerializableFunction;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.Deserializer;
import org.joda.time.Duration;
import org.joda.time.Instant;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_KafkaIO_Read<K, V> extends KafkaIO.Read<K, V> {

  private final Map<String, Object> consumerConfig;

  private final ValueProvider<String> bootstrapServers;

  private final ValueProvider<List<String>> topics;

  private final List<TopicPartition> topicPartitions;

  private final Coder<K> keyCoder;

  private final Coder<V> valueCoder;

  private final Class<? extends Deserializer<K>> keyDeserializer;

  private final Class<? extends Deserializer<V>> valueDeserializer;

  private final SerializableFunction<Map<String, Object>, Consumer<byte[], byte[]>> consumerFactoryFn;

  private final SerializableFunction<KafkaRecord<K, V>, Instant> watermarkFn;

  private final long maxNumRecords;

  private final Duration maxReadTime;

  private final Instant startReadTime;

  private final boolean commitOffsetsInFinalizeEnabled;

  private final TimestampPolicyFactory<K, V> timestampPolicyFactory;

  private final int numSplits;

  private AutoValue_KafkaIO_Read(
      Map<String, Object> consumerConfig,
      @Nullable ValueProvider<String> bootstrapServers,
      @Nullable ValueProvider<List<String>> topics,
      List<TopicPartition> topicPartitions,
      @Nullable Coder<K> keyCoder,
      @Nullable Coder<V> valueCoder,
      @Nullable Class<? extends Deserializer<K>> keyDeserializer,
      @Nullable Class<? extends Deserializer<V>> valueDeserializer,
      SerializableFunction<Map<String, Object>, Consumer<byte[], byte[]>> consumerFactoryFn,
      @Nullable SerializableFunction<KafkaRecord<K, V>, Instant> watermarkFn,
      long maxNumRecords,
      @Nullable Duration maxReadTime,
      @Nullable Instant startReadTime,
      boolean commitOffsetsInFinalizeEnabled,
      TimestampPolicyFactory<K, V> timestampPolicyFactory,
      int numSplits) {
    this.consumerConfig = consumerConfig;
    this.bootstrapServers = bootstrapServers;
    this.topics = topics;
    this.topicPartitions = topicPartitions;
    this.keyCoder = keyCoder;
    this.valueCoder = valueCoder;
    this.keyDeserializer = keyDeserializer;
    this.valueDeserializer = valueDeserializer;
    this.consumerFactoryFn = consumerFactoryFn;
    this.watermarkFn = watermarkFn;
    this.maxNumRecords = maxNumRecords;
    this.maxReadTime = maxReadTime;
    this.startReadTime = startReadTime;
    this.commitOffsetsInFinalizeEnabled = commitOffsetsInFinalizeEnabled;
    this.timestampPolicyFactory = timestampPolicyFactory;
    this.numSplits = numSplits;
  }

  @Override
  Map<String, Object> getConsumerConfig() {
    return consumerConfig;
  }

  @Nullable
  @Override
  ValueProvider<String> getBootstrapServers() {
    return bootstrapServers;
  }

  @Nullable
  @Override
  ValueProvider<List<String>> getTopics() {
    return topics;
  }

  @Override
  List<TopicPartition> getTopicPartitions() {
    return topicPartitions;
  }

  @Nullable
  @Override
  Coder<K> getKeyCoder() {
    return keyCoder;
  }

  @Nullable
  @Override
  Coder<V> getValueCoder() {
    return valueCoder;
  }

  @Nullable
  @Override
  Class<? extends Deserializer<K>> getKeyDeserializer() {
    return keyDeserializer;
  }

  @Nullable
  @Override
  Class<? extends Deserializer<V>> getValueDeserializer() {
    return valueDeserializer;
  }

  @Override
  SerializableFunction<Map<String, Object>, Consumer<byte[], byte[]>> getConsumerFactoryFn() {
    return consumerFactoryFn;
  }

  @Nullable
  @Override
  SerializableFunction<KafkaRecord<K, V>, Instant> getWatermarkFn() {
    return watermarkFn;
  }

  @Override
  long getMaxNumRecords() {
    return maxNumRecords;
  }

  @Nullable
  @Override
  Duration getMaxReadTime() {
    return maxReadTime;
  }

  @Nullable
  @Override
  Instant getStartReadTime() {
    return startReadTime;
  }

  @Override
  boolean isCommitOffsetsInFinalizeEnabled() {
    return commitOffsetsInFinalizeEnabled;
  }

  @Override
  TimestampPolicyFactory<K, V> getTimestampPolicyFactory() {
    return timestampPolicyFactory;
  }

  @Override
  int getNumSplits() {
    return numSplits;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof KafkaIO.Read) {
      KafkaIO.Read<?, ?> that = (KafkaIO.Read<?, ?>) o;
      return this.consumerConfig.equals(that.getConsumerConfig())
          && (this.bootstrapServers == null ? that.getBootstrapServers() == null : this.bootstrapServers.equals(that.getBootstrapServers()))
          && (this.topics == null ? that.getTopics() == null : this.topics.equals(that.getTopics()))
          && this.topicPartitions.equals(that.getTopicPartitions())
          && (this.keyCoder == null ? that.getKeyCoder() == null : this.keyCoder.equals(that.getKeyCoder()))
          && (this.valueCoder == null ? that.getValueCoder() == null : this.valueCoder.equals(that.getValueCoder()))
          && (this.keyDeserializer == null ? that.getKeyDeserializer() == null : this.keyDeserializer.equals(that.getKeyDeserializer()))
          && (this.valueDeserializer == null ? that.getValueDeserializer() == null : this.valueDeserializer.equals(that.getValueDeserializer()))
          && this.consumerFactoryFn.equals(that.getConsumerFactoryFn())
          && (this.watermarkFn == null ? that.getWatermarkFn() == null : this.watermarkFn.equals(that.getWatermarkFn()))
          && this.maxNumRecords == that.getMaxNumRecords()
          && (this.maxReadTime == null ? that.getMaxReadTime() == null : this.maxReadTime.equals(that.getMaxReadTime()))
          && (this.startReadTime == null ? that.getStartReadTime() == null : this.startReadTime.equals(that.getStartReadTime()))
          && this.commitOffsetsInFinalizeEnabled == that.isCommitOffsetsInFinalizeEnabled()
          && this.timestampPolicyFactory.equals(that.getTimestampPolicyFactory())
          && this.numSplits == that.getNumSplits();
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= consumerConfig.hashCode();
    h$ *= 1000003;
    h$ ^= (bootstrapServers == null) ? 0 : bootstrapServers.hashCode();
    h$ *= 1000003;
    h$ ^= (topics == null) ? 0 : topics.hashCode();
    h$ *= 1000003;
    h$ ^= topicPartitions.hashCode();
    h$ *= 1000003;
    h$ ^= (keyCoder == null) ? 0 : keyCoder.hashCode();
    h$ *= 1000003;
    h$ ^= (valueCoder == null) ? 0 : valueCoder.hashCode();
    h$ *= 1000003;
    h$ ^= (keyDeserializer == null) ? 0 : keyDeserializer.hashCode();
    h$ *= 1000003;
    h$ ^= (valueDeserializer == null) ? 0 : valueDeserializer.hashCode();
    h$ *= 1000003;
    h$ ^= consumerFactoryFn.hashCode();
    h$ *= 1000003;
    h$ ^= (watermarkFn == null) ? 0 : watermarkFn.hashCode();
    h$ *= 1000003;
    h$ ^= (int) ((maxNumRecords >>> 32) ^ maxNumRecords);
    h$ *= 1000003;
    h$ ^= (maxReadTime == null) ? 0 : maxReadTime.hashCode();
    h$ *= 1000003;
    h$ ^= (startReadTime == null) ? 0 : startReadTime.hashCode();
    h$ *= 1000003;
    h$ ^= commitOffsetsInFinalizeEnabled ? 1231 : 1237;
    h$ *= 1000003;
    h$ ^= timestampPolicyFactory.hashCode();
    h$ *= 1000003;
    h$ ^= numSplits;
    return h$;
  }

  @Override
  KafkaIO.Read.Builder<K, V> toBuilder() {
    return new Builder<K, V>(this);
  }

  static final class Builder<K, V> extends KafkaIO.Read.Builder<K, V> {
    private Map<String, Object> consumerConfig;
    private ValueProvider<String> bootstrapServers;
    private ValueProvider<List<String>> topics;
    private List<TopicPartition> topicPartitions;
    private Coder<K> keyCoder;
    private Coder<V> valueCoder;
    private Class<? extends Deserializer<K>> keyDeserializer;
    private Class<? extends Deserializer<V>> valueDeserializer;
    private SerializableFunction<Map<String, Object>, Consumer<byte[], byte[]>> consumerFactoryFn;
    private SerializableFunction<KafkaRecord<K, V>, Instant> watermarkFn;
    private Long maxNumRecords;
    private Duration maxReadTime;
    private Instant startReadTime;
    private Boolean commitOffsetsInFinalizeEnabled;
    private TimestampPolicyFactory<K, V> timestampPolicyFactory;
    private Integer numSplits;
    Builder() {
    }
    private Builder(KafkaIO.Read<K, V> source) {
      this.consumerConfig = source.getConsumerConfig();
      this.bootstrapServers = source.getBootstrapServers();
      this.topics = source.getTopics();
      this.topicPartitions = source.getTopicPartitions();
      this.keyCoder = source.getKeyCoder();
      this.valueCoder = source.getValueCoder();
      this.keyDeserializer = source.getKeyDeserializer();
      this.valueDeserializer = source.getValueDeserializer();
      this.consumerFactoryFn = source.getConsumerFactoryFn();
      this.watermarkFn = source.getWatermarkFn();
      this.maxNumRecords = source.getMaxNumRecords();
      this.maxReadTime = source.getMaxReadTime();
      this.startReadTime = source.getStartReadTime();
      this.commitOffsetsInFinalizeEnabled = source.isCommitOffsetsInFinalizeEnabled();
      this.timestampPolicyFactory = source.getTimestampPolicyFactory();
      this.numSplits = source.getNumSplits();
    }
    @Override
    KafkaIO.Read.Builder<K, V> setConsumerConfig(Map<String, Object> consumerConfig) {
      if (consumerConfig == null) {
        throw new NullPointerException("Null consumerConfig");
      }
      this.consumerConfig = consumerConfig;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setBootstrapServers(ValueProvider<String> bootstrapServers) {
      this.bootstrapServers = bootstrapServers;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setTopics(ValueProvider<List<String>> topics) {
      this.topics = topics;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setTopicPartitions(List<TopicPartition> topicPartitions) {
      if (topicPartitions == null) {
        throw new NullPointerException("Null topicPartitions");
      }
      this.topicPartitions = topicPartitions;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setKeyCoder(Coder<K> keyCoder) {
      this.keyCoder = keyCoder;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setValueCoder(Coder<V> valueCoder) {
      this.valueCoder = valueCoder;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setKeyDeserializer(Class<? extends Deserializer<K>> keyDeserializer) {
      this.keyDeserializer = keyDeserializer;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setValueDeserializer(Class<? extends Deserializer<V>> valueDeserializer) {
      this.valueDeserializer = valueDeserializer;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setConsumerFactoryFn(SerializableFunction<Map<String, Object>, Consumer<byte[], byte[]>> consumerFactoryFn) {
      if (consumerFactoryFn == null) {
        throw new NullPointerException("Null consumerFactoryFn");
      }
      this.consumerFactoryFn = consumerFactoryFn;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setWatermarkFn(SerializableFunction<KafkaRecord<K, V>, Instant> watermarkFn) {
      this.watermarkFn = watermarkFn;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setMaxNumRecords(long maxNumRecords) {
      this.maxNumRecords = maxNumRecords;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setMaxReadTime(Duration maxReadTime) {
      this.maxReadTime = maxReadTime;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setStartReadTime(Instant startReadTime) {
      this.startReadTime = startReadTime;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setCommitOffsetsInFinalizeEnabled(boolean commitOffsetsInFinalizeEnabled) {
      this.commitOffsetsInFinalizeEnabled = commitOffsetsInFinalizeEnabled;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setTimestampPolicyFactory(TimestampPolicyFactory<K, V> timestampPolicyFactory) {
      if (timestampPolicyFactory == null) {
        throw new NullPointerException("Null timestampPolicyFactory");
      }
      this.timestampPolicyFactory = timestampPolicyFactory;
      return this;
    }
    @Override
    KafkaIO.Read.Builder<K, V> setNumSplits(int numSplits) {
      this.numSplits = numSplits;
      return this;
    }
    @Override
    KafkaIO.Read<K, V> build() {
      String missing = "";
      if (this.consumerConfig == null) {
        missing += " consumerConfig";
      }
      if (this.topicPartitions == null) {
        missing += " topicPartitions";
      }
      if (this.consumerFactoryFn == null) {
        missing += " consumerFactoryFn";
      }
      if (this.maxNumRecords == null) {
        missing += " maxNumRecords";
      }
      if (this.commitOffsetsInFinalizeEnabled == null) {
        missing += " commitOffsetsInFinalizeEnabled";
      }
      if (this.timestampPolicyFactory == null) {
        missing += " timestampPolicyFactory";
      }
      if (this.numSplits == null) {
        missing += " numSplits";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_KafkaIO_Read<K, V>(
          this.consumerConfig,
          this.bootstrapServers,
          this.topics,
          this.topicPartitions,
          this.keyCoder,
          this.valueCoder,
          this.keyDeserializer,
          this.valueDeserializer,
          this.consumerFactoryFn,
          this.watermarkFn,
          this.maxNumRecords,
          this.maxReadTime,
          this.startReadTime,
          this.commitOffsetsInFinalizeEnabled,
          this.timestampPolicyFactory,
          this.numSplits);
    }
  }

}
