package com.github.leojbours.paymentservice.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JsonProducerConfig {
  private final KafkaProperties kafkaProperties;

  @Bean
  public ProducerFactory<String, Serializable> producerFactory() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
    configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);
    return new DefaultKafkaProducerFactory<>(configs);
  }

  @Bean
  public KafkaTemplate<String, Serializable> jsonKafkaTemplate(ProducerFactory<String, Serializable> producerFactory) {
    return new KafkaTemplate<>(producerFactory);
  }
}
