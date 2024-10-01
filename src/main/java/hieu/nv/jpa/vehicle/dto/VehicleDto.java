package hieu.nv.jpa.vehicle.dto;

import lombok.Data;

@Data
public class VehicleDto {

	private String id;
	private String manufacturer;
	private boolean hasSidecar;
	private int seats;
	private String vehicle_type;

}
