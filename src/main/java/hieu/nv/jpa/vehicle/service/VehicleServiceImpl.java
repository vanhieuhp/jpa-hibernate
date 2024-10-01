package hieu.nv.jpa.vehicle.service;

import hieu.nv.jpa.vehicle.dto.VehicleDto;
import hieu.nv.jpa.vehicle.entity.Vehicle;
import hieu.nv.jpa.vehicle.entity.VehicleBike;
import hieu.nv.jpa.vehicle.entity.VehicleCar;
import hieu.nv.jpa.vehicle.repository.VehicleCarRepository;
import hieu.nv.jpa.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

	private final VehicleRepository vehicleRepository;
	private final VehicleCarRepository vehicleCarRepository;

	@Override
	public List<VehicleCar> getAllCars() {
		return vehicleCarRepository.findAll();
	}

	@Override
	public VehicleCar getCarById(String carId) {
		return vehicleCarRepository.findById(carId).orElse(null);
	}

	@Override
	public VehicleCar saveCar(VehicleCar vehicle) {
		return vehicleCarRepository.save(vehicle);
	}

	@Override
	public VehicleCar updateCar(String carId, VehicleCar vehicle) {
		if (vehicleCarRepository.existsById(carId)) {
			vehicle.setId(carId);
			return vehicleCarRepository.save(vehicle);
		}
		return null;
	}

	@Override
	public void deleteCar(String carId) {
		vehicleCarRepository.deleteById(carId);
	}

	@Override
	public VehicleBike saveBike(VehicleBike vehicleBike) {
		vehicleRepository.save(vehicleBike);
		return vehicleBike;
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAllVehicles();
	}
}
