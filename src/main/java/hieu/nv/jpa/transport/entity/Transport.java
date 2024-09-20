package hieu.nv.jpa.transport.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transports")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transport {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "manufacturer")
	private String manufacturer;
}
