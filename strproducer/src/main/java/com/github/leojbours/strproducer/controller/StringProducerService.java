package com.github.leojbours.strproducer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StringProducerService {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void send(String message) {
    log.info("Sending message: {}", message);
    kafkaTemplate.send("str-topic", message);
  }
}
