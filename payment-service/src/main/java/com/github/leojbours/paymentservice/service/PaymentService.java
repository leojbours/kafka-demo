package com.github.leojbours.paymentservice.service;

import com.github.leojbours.paymentservice.entity.Payment;

public interface PaymentService {
  Payment newPayment(Payment payment);
}
