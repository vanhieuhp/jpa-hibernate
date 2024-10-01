package hieu.nv.jpa.animals.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cats")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cat extends Animal {

	@Column(name = "legs")
	private int legs;
}
