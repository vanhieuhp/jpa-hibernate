package hieu.nv.jpa.smartphone.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "smartphones")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SmartPhone {

	@Id
	@Column(name = "id", nullable = false)
	@UuidGenerator
	private String id;

	@Column(name = "name", nullable = false)
	private String color;

	@Column(name = "price", nullable = false)
	private BigDecimal price;
}
