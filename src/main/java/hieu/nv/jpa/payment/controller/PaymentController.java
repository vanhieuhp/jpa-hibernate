package hieu.nv.jpa.payment.controller;

import hieu.nv.jpa.payment.entity.Payment;
import hieu.nv.jpa.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment newPayment = paymentService.createPayment(payment);
        return ResponseEntity.ok(newPayment);
    }

    @GetMapping
    public ResponseEntity<Iterable<Payment>> getAllPayments() {
        Iterable<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id) {
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> getTotalAmount() {
        BigDecimal totalAmount = paymentService.getTotalAmount();
        return ResponseEntity.ok(totalAmount);
    }
}
