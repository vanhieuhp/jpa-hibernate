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
@Table(name = "bikes")
@PrimaryKeyJoinColumn(name = "id")
public class Bike extends Transport {

	@Column(name = "has_sidecar")
	private boolean hasSidecar;
}
