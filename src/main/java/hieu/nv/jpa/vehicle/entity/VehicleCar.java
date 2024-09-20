package hieu.nv.jpa.vehicle.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Car")
public class VehicleCar extends Vehicle {

	private int seats;
}
