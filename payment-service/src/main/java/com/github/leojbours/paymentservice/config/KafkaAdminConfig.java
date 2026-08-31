package com.github.leojbours.paymentservice.config;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaAdmin.NewTopics;

@Configuration
@RequiredArgsConstructor
public class KafkaAdminConfig {
  private final KafkaProperties kafkaProperties;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
    return new KafkaAdmin(configs);
  }

  @Bean
  public KafkaAdmin.NewTopics topics() {
    return new NewTopics(
        TopicBuilder.name("payment-topic").partitions(1).build()
    );
  }
}
