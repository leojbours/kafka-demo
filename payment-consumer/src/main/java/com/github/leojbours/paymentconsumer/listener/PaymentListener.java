package com.github.leojbours.paymentconsumer.listener;

import com.github.leojbours.paymentconsumer.entity.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class PaymentListener {

  @KafkaListener(topics = {"payment-topic"}, groupId = "new-payment", containerFactory = "jsonContainerFactory")
  public void payment(@Payload Payment payment) {
    log.info("Received payment: {}", payment);
  }
}
