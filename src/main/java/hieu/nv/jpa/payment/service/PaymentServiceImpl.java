package hieu.nv.jpa.payment.service;

import hieu.nv.jpa.payment.entity.Payment;
import hieu.nv.jpa.payment.entity.PaymentSummary;
import hieu.nv.jpa.payment.repository.PaymentRepository;
import hieu.nv.jpa.product.entity.Product;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
@Log4j2
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
        return paymentRepository.findSummary().getTotalAmount();
    }

    @Override
    public Payment updatePayment(String id, Payment payment) {
        Payment existingPayment = paymentRepository.findById(id).orElse(null);
        if (existingPayment == null) {
            return null;
        }
        existingPayment.setAmount(payment.getAmount());
        return paymentRepository.save(existingPayment);
    }

    @Override
    @Transactional
    public Payment decreasePayment(String id, BigDecimal amount) {
        try {
//            Payment payment = paymentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            Payment payment = paymentRepository.findByIdLocked(id).orElseThrow(EntityNotFoundException::new);

            BigDecimal newAmount = payment.getAmount().subtract(amount);
            payment.setAmount(newAmount);
            return paymentRepository.save(payment);
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
            return null;
        }

    }
}
