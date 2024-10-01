package hieu.nv.jpa.animals.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dogs")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Dog extends Animal {

	@Column(name = "color")
	private String color;
}
