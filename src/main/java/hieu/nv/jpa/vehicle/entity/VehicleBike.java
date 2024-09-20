package hieu.nv.jpa.vehicle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Bike")
public class VehicleBike extends Vehicle {

	@Column(name = "has_sidecar")
	private boolean hasSidecar;
}
