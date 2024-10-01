package hieu.nv.jpa.animals.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "animals")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "name")
	private String name;
}
