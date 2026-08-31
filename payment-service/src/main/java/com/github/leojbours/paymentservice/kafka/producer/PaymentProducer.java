package com.github.leojbours.paymentservice.kafka.producer;

import com.github.leojbours.paymentservice.entity.Payment;

public interface PaymentProducer {
  void newPayment(Payment payment);
}
