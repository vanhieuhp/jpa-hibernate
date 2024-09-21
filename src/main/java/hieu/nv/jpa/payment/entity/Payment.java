package hieu.nv.jpa.payment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
@NamedNativeQuery(name = "Payment.findSummary",
        query = "SELECT SUM(p.amount) AS totalAmount FROM payments p",
        resultSetMapping = "PaymentSummaryMapping")

@SqlResultSetMapping(name = "PaymentSummaryMapping",
        classes = @ConstructorResult(targetClass = PaymentSummary.class,
                columns = {@ColumnResult(name = "totalAmount", type = BigDecimal.class)}))

public class Payment {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "amount")
    private BigDecimal amount;
}
