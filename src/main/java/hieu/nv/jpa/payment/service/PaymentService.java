package hieu.nv.jpa.payment.service;

import hieu.nv.jpa.payment.entity.Payment;

import java.math.BigDecimal;

public interface PaymentService {
    Payment createPayment(Payment payment);

    Iterable<Payment> getAllPayments();

    Payment getPaymentById(String id);

    BigDecimal getTotalAmount();

    Payment updatePayment(String id, Payment payment);

    Payment decreasePayment(String id, BigDecimal amount);
}
