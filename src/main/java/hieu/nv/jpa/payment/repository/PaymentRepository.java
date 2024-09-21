package hieu.nv.jpa.payment.repository;

import hieu.nv.jpa.payment.entity.Payment;
import hieu.nv.jpa.payment.entity.PaymentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    @Query(name = "Payment.findSummary", nativeQuery = true)
    List<PaymentSummary> findSummary();
}