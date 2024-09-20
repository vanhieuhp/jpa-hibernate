package hieu.nv.jpa.transport.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
@PrimaryKeyJoinColumn(name = "id")
public class Car extends Transport {

	@Column(name = "seats")
	private int seats;
}
