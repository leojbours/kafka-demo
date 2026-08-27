package com.github.leojbours.strconsumer.listeners;

import com.github.leojbours.strconsumer.custom.StrConsumerCustomListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class StrConsumerListener {

  @StrConsumerCustomListener(groupId = "group-1")
  public void listener(String message) {
    log.info("Received message: {}", message);
  }

  @StrConsumerCustomListener(groupId = "group-1")
  public void log(String message) {
    log.info("Logged message: {}", message);
  }

  @KafkaListener(topics = {"str-topic"}, containerFactory = "strContainerFactoryWithInterceptor", groupId = "group-2")
  public void process(String message) {
    log.info("Processed message: {}", message);
  }
}
