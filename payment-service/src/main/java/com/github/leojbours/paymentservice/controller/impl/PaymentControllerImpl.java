package com.github.leojbours.paymentservice.controller.impl;

import com.github.leojbours.paymentservice.entity.Payment;
import com.github.leojbours.paymentservice.controller.PaymentController;
import com.github.leojbours.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentControllerImpl implements PaymentController {
  private final PaymentService paymentService;

  @Override
  public ResponseEntity<Payment> newPayment(@RequestBody Payment payment) {
    Payment savedPayment = paymentService.newPayment(payment);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedPayment);
  }
}
