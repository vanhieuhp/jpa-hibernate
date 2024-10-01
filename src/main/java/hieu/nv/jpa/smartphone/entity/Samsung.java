package hieu.nv.jpa.smartphone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "samsung")
@PrimaryKeyJoinColumn(name = "id")
public class Samsung extends SmartPhone {

	@Column(name = "size")
	private String size;
}
