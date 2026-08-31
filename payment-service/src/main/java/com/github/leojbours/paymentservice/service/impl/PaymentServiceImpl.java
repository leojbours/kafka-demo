package com.github.leojbours.paymentservice.service.impl;

import com.github.leojbours.paymentservice.entity.Payment;
import com.github.leojbours.paymentservice.kafka.producer.PaymentProducer;
import com.github.leojbours.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
  private final PaymentProducer paymentProducer;

  @Override
  public Payment newPayment(Payment payment) {
    log.info("NEW PAYMENT ::: {}", payment);

    paymentProducer.newPayment(payment);

    return payment;
  }
}
