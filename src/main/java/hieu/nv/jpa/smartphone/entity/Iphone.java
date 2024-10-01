package hieu.nv.jpa.smartphone.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "iphone")
@PrimaryKeyJoinColumn(name = "id")
public class Iphone extends SmartPhone {

	@Column(name = "model")
	private String model;
}
