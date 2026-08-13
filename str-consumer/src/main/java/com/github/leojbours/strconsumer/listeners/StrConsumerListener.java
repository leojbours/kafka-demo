package com.github.leojbours.strconsumer.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class StrConsumerListener {

  @KafkaListener(groupId = "str-consumer-group", topics = "str-topic", containerFactory = "strContainerFactory")
  public void listener(String message) {
    log.info("Received message: {}", message);
  }
}
