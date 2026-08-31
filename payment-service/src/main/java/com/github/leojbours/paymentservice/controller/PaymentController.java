package com.github.leojbours.paymentservice.controller;

import com.github.leojbours.paymentservice.entity.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface PaymentController {

  @PostMapping
  ResponseEntity<Payment> newPayment(Payment payment);
}
