package com.google.cloud.teleport.kafka.connector;

import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.processing.Generated;
import org.apache.beam.sdk.transforms.SerializableFunction;
import org.apache.beam.sdk.values.KV;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.serialization.Serializer;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_KafkaIO_Write<K, V> extends KafkaIO.Write<K, V> {

  private final String topic;

  private final Map<String, Object> producerConfig;

  private final SerializableFunction<Map<String, Object>, Producer<K, V>> producerFactoryFn;

  private final Class<? extends Serializer<K>> keySerializer;

  private final Class<? extends Serializer<V>> valueSerializer;

  private final KafkaPublishTimestampFunction<KV<K, V>> publishTimestampFunction;

  private final boolean EOS;

  private final String sinkGroupId;

  private final int numShards;

  private final SerializableFunction<Map<String, Object>, ? extends Consumer<?, ?>> consumerFactoryFn;

  private AutoValue_KafkaIO_Write(
      @Nullable String topic,
      Map<String, Object> producerConfig,
      @Nullable SerializableFunction<Map<String, Object>, Producer<K, V>> producerFactoryFn,
      @Nullable Class<? extends Serializer<K>> keySerializer,
      @Nullable Class<? extends Serializer<V>> valueSerializer,
      @Nullable KafkaPublishTimestampFunction<KV<K, V>> publishTimestampFunction,
      boolean EOS,
      @Nullable String sinkGroupId,
      int numShards,
      @Nullable SerializableFunction<Map<String, Object>, ? extends Consumer<?, ?>> consumerFactoryFn) {
    this.topic = topic;
    this.producerConfig = producerConfig;
    this.producerFactoryFn = producerFactoryFn;
    this.keySerializer = keySerializer;
    this.valueSerializer = valueSerializer;
    this.publishTimestampFunction = publishTimestampFunction;
    this.EOS = EOS;
    this.sinkGroupId = sinkGroupId;
    this.numShards = numShards;
    this.consumerFactoryFn = consumerFactoryFn;
  }

  @Nullable
  @Override
  String getTopic() {
    return topic;
  }

  @Override
  Map<String, Object> getProducerConfig() {
    return producerConfig;
  }

  @Nullable
  @Override
  SerializableFunction<Map<String, Object>, Producer<K, V>> getProducerFactoryFn() {
    return producerFactoryFn;
  }

  @Nullable
  @Override
  Class<? extends Serializer<K>> getKeySerializer() {
    return keySerializer;
  }

  @Nullable
  @Override
  Class<? extends Serializer<V>> getValueSerializer() {
    return valueSerializer;
  }

  @Nullable
  @Override
  KafkaPublishTimestampFunction<KV<K, V>> getPublishTimestampFunction() {
    return publishTimestampFunction;
  }

  @Override
  boolean isEOS() {
    return EOS;
  }

  @Nullable
  @Override
  String getSinkGroupId() {
    return sinkGroupId;
  }

  @Override
  int getNumShards() {
    return numShards;
  }

  @Nullable
  @Override
  SerializableFunction<Map<String, Object>, ? extends Consumer<?, ?>> getConsumerFactoryFn() {
    return consumerFactoryFn;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof KafkaIO.Write) {
      KafkaIO.Write<?, ?> that = (KafkaIO.Write<?, ?>) o;
      return (this.topic == null ? that.getTopic() == null : this.topic.equals(that.getTopic()))
          && this.producerConfig.equals(that.getProducerConfig())
          && (this.producerFactoryFn == null ? that.getProducerFactoryFn() == null : this.producerFactoryFn.equals(that.getProducerFactoryFn()))
          && (this.keySerializer == null ? that.getKeySerializer() == null : this.keySerializer.equals(that.getKeySerializer()))
          && (this.valueSerializer == null ? that.getValueSerializer() == null : this.valueSerializer.equals(that.getValueSerializer()))
          && (this.publishTimestampFunction == null ? that.getPublishTimestampFunction() == null : this.publishTimestampFunction.equals(that.getPublishTimestampFunction()))
          && this.EOS == that.isEOS()
          && (this.sinkGroupId == null ? that.getSinkGroupId() == null : this.sinkGroupId.equals(that.getSinkGroupId()))
          && this.numShards == that.getNumShards()
          && (this.consumerFactoryFn == null ? that.getConsumerFactoryFn() == null : this.consumerFactoryFn.equals(that.getConsumerFactoryFn()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= (topic == null) ? 0 : topic.hashCode();
    h$ *= 1000003;
    h$ ^= producerConfig.hashCode();
    h$ *= 1000003;
    h$ ^= (producerFactoryFn == null) ? 0 : producerFactoryFn.hashCode();
    h$ *= 1000003;
    h$ ^= (keySerializer == null) ? 0 : keySerializer.hashCode();
    h$ *= 1000003;
    h$ ^= (valueSerializer == null) ? 0 : valueSerializer.hashCode();
    h$ *= 1000003;
    h$ ^= (publishTimestampFunction == null) ? 0 : publishTimestampFunction.hashCode();
    h$ *= 1000003;
    h$ ^= EOS ? 1231 : 1237;
    h$ *= 1000003;
    h$ ^= (sinkGroupId == null) ? 0 : sinkGroupId.hashCode();
    h$ *= 1000003;
    h$ ^= numShards;
    h$ *= 1000003;
    h$ ^= (consumerFactoryFn == null) ? 0 : consumerFactoryFn.hashCode();
    return h$;
  }

  @Override
  KafkaIO.Write.Builder<K, V> toBuilder() {
    return new Builder<K, V>(this);
  }

  static final class Builder<K, V> extends KafkaIO.Write.Builder<K, V> {
    private String topic;
    private Map<String, Object> producerConfig;
    private SerializableFunction<Map<String, Object>, Producer<K, V>> producerFactoryFn;
    private Class<? extends Serializer<K>> keySerializer;
    private Class<? extends Serializer<V>> valueSerializer;
    private KafkaPublishTimestampFunction<KV<K, V>> publishTimestampFunction;
    private Boolean EOS;
    private String sinkGroupId;
    private Integer numShards;
    private SerializableFunction<Map<String, Object>, ? extends Consumer<?, ?>> consumerFactoryFn;
    Builder() {
    }
    private Builder(KafkaIO.Write<K, V> source) {
      this.topic = source.getTopic();
      this.producerConfig = source.getProducerConfig();
      this.producerFactoryFn = source.getProducerFactoryFn();
      this.keySerializer = source.getKeySerializer();
      this.valueSerializer = source.getValueSerializer();
      this.publishTimestampFunction = source.getPublishTimestampFunction();
      this.EOS = source.isEOS();
      this.sinkGroupId = source.getSinkGroupId();
      this.numShards = source.getNumShards();
      this.consumerFactoryFn = source.getConsumerFactoryFn();
    }
    @Override
    KafkaIO.Write.Builder<K, V> setTopic(String topic) {
      this.topic = topic;
      return this;
    }
    @Override
    KafkaIO.Write.Builder<K, V> setProducerConfig(Map<String, Object> producerConfig) {
      if (producerConfig == null) {
        throw new NullPointerException("Null producerConfig");
      }
      this.producerConfig = producerConfig;
      return this;
    }
    @Override
    KafkaIO.Write.Builder<K, V> setProducerFactoryFn(SerializableFunction<Map<String, Object>, Producer<K, V>> producerFactoryFn) {
      this.producerFactoryFn = producerFactoryFn;
      return this;
    }
    @Override
    KafkaIO.Write.Builder<K, V> setKeySerializer(Class<? extends Serializer<K>> keySerializer) {
      this.keySerializer = keySerializer;
      return this;
    }
    @Override
    KafkaIO.Write.Builder<K, V> setValueSerializer(Class<? extends Serializer<V>> valueSerializer) {
      this.valueSerializer = valueSerializer;
      return this;
    }
    @Override
    KafkaIO.Write.Builder<K, V> setPublishTimestampFunction(KafkaPublishTimestampFunction<KV<K, V>> publishTimestampFunction) {
      this.publishTimestampFunction = publishTimestampFunction;
      return this;
    }
    @Override
    KafkaIO.Write.Builder<K, V> setEOS(boolean EOS) {
      this.EOS = EOS;
      return this;
    }
    @Override
    KafkaIO.Write.Builder<K, V> setSinkGroupId(String sinkGroupId) {
      this.sinkGroupId = sinkGroupId;
      return this;
    }
    @Override
    KafkaIO.Write.Builder<K, V> setNumShards(int numShards) {
      this.numShards = numShards;
      return this;
    }
    @Override
    KafkaIO.Write.Builder<K, V> setConsumerFactoryFn(SerializableFunction<Map<String, Object>, ? extends Consumer<?, ?>> consumerFactoryFn) {
      this.consumerFactoryFn = consumerFactoryFn;
      return this;
    }
    @Override
    KafkaIO.Write<K, V> build() {
      String missing = "";
      if (this.producerConfig == null) {
        missing += " producerConfig";
      }
      if (this.EOS == null) {
        missing += " EOS";
      }
      if (this.numShards == null) {
        missing += " numShards";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_KafkaIO_Write<K, V>(
          this.topic,
          this.producerConfig,
          this.producerFactoryFn,
          this.keySerializer,
          this.valueSerializer,
          this.publishTimestampFunction,
          this.EOS,
          this.sinkGroupId,
          this.numShards,
          this.consumerFactoryFn);
    }
  }

}
