package hieu.nv.jpa.vehicle.service;

import hieu.nv.jpa.vehicle.entity.VehicleBike;
import hieu.nv.jpa.vehicle.entity.VehicleCar;

import java.util.List;

public interface VehicleService {
	List<VehicleCar> getAllCars();

	VehicleCar getCarById(String carId);

	VehicleCar saveCar(VehicleCar vehicleCarDto);

	VehicleCar updateCar(String carId, VehicleCar vehicleCarDto);

	void deleteCar(String carId);

	VehicleBike saveBike(VehicleBike vehicleBike);
}
