package hieu.nv.jpa.payment.entity;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SqlResultSetMapping(
        name = "PaymentSummaryMapping",
        classes = @ConstructorResult(
                targetClass = PaymentSummary.class,
                columns = {
                        @ColumnResult(name = "totalAmount", type = BigDecimal.class)
                }
        )
)
public class PaymentSummary {

    private BigDecimal totalAmount;
}
