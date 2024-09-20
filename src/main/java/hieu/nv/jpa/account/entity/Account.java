package hieu.nv.jpa.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account extends BaseEntity {

	@Column(name = "balance", precision = 10, scale = 2)
	private BigDecimal balance;

	@Column(name = "is_active")
	private Boolean isActive;
}
