package hieu.nv.jpa.payment.service;

import hieu.nv.jpa.payment.entity.Payment;
import hieu.nv.jpa.payment.entity.PaymentSummary;
import hieu.nv.jpa.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Iterable<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(String id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public BigDecimal getTotalAmount() {
        return paymentRepository.findSummary().get(0).getTotalAmount();
    }
}
