package hieu.nv.jpa.payment.repository;

import hieu.nv.jpa.payment.entity.Payment;
import hieu.nv.jpa.payment.entity.PaymentSummary;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    @Query(name = "Payment.findSummary", nativeQuery = true)
    PaymentSummary findSummary();

    @Query("select p from Payment p where p.id = :id")
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Payment> findByIdLocked(String id);
}