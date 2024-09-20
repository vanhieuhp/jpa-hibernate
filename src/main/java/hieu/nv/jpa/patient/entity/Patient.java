package hieu.nv.jpa.patient.entity;
import hieu.nv.jpa.address.entity.Address;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "name")
	private String name;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(
					name = "street",
					column = @Column(name = "permanent_street")
			),
			@AttributeOverride(
					name = "city",
					column = @Column(name = "permanent_city")
			)
	})
	private Address permanentAddress;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(
					name = "street",
					column = @Column(name = "temporary_street")
			),
			@AttributeOverride(
					name = "city",
					column = @Column(name = "temporary_city")
			)
	})
	private Address temporaryAddress;
}
