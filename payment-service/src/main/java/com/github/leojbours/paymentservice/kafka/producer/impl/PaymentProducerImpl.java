package com.github.leojbours.paymentservice.kafka.producer.impl;

import com.github.leojbours.paymentservice.entity.Payment;
import com.github.leojbours.paymentservice.kafka.producer.PaymentProducer;
import java.io.Serializable;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentProducerImpl implements PaymentProducer {
  private final KafkaTemplate<String, Serializable> kafkaTemplate;

  @Override
  public void newPayment(Payment payment) {
    kafkaTemplate.send("payment-topic", payment);
  }
}
