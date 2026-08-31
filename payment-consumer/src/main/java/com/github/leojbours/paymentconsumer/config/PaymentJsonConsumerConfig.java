package com.github.leojbours.paymentconsumer.config;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.JacksonJsonMessageConverter;

@Configuration
@RequiredArgsConstructor
public class PaymentJsonConsumerConfig {

  private final KafkaProperties properties;

  @Bean
  public ConsumerFactory<String, Object> jsonConsumerFactory() {
    var configs = new HashMap<String, Object>();
    configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
    configs.put(ConsumerConfig.GROUP_ID_CONFIG, "new-payment");
    configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    return new DefaultKafkaConsumerFactory<>(configs);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Object> jsonContainerFactory(
      ConsumerFactory<String, Object> jsonConsumerFactory
  ) {
    var factory = new ConcurrentKafkaListenerContainerFactory<String, Object>();
    factory.setConsumerFactory(jsonConsumerFactory);
    factory.setRecordMessageConverter(new JacksonJsonMessageConverter());
    return factory;
  }
}