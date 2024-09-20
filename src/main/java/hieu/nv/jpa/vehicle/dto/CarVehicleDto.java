package hieu.nv.jpa.vehicle.dto;

import hieu.nv.jpa.vehicle.entity.VehicleCar;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link VehicleCar}
 */
@Value
public class CarVehicleDto implements Serializable {
	Long id;
	String manufacturer;
	int seats;
}