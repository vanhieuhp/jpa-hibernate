package hieu.nv.jpa.vehicle.controller;

import hieu.nv.jpa.vehicle.dto.VehicleDto;
import hieu.nv.jpa.vehicle.entity.Vehicle;
import hieu.nv.jpa.vehicle.entity.VehicleBike;
import hieu.nv.jpa.vehicle.entity.VehicleCar;
import hieu.nv.jpa.vehicle.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

	private final VehicleService vehicleService;

	@PostMapping("/bikes")
	public VehicleBike saveBike(@RequestBody VehicleBike vehicleBike) {
		return vehicleService.saveBike(vehicleBike);
	}

	@GetMapping("/cars")
	public List<VehicleCar> getAllCars() {
		return vehicleService.getAllCars();
	}

	@GetMapping("/cars/{carId}")
	public VehicleCar getCarById(@PathVariable String carId) {
		return vehicleService.getCarById(carId);
	}

	@PostMapping("/cars")
	public VehicleCar saveCar(@RequestBody VehicleCar vehicleCar) {
		return vehicleService.saveCar(vehicleCar);
	}

	@PutMapping("/cars/{carId}")
	public VehicleCar updateCar(@PathVariable String carId, @RequestBody VehicleCar vehicleCar) {
		return vehicleService.updateCar(carId, vehicleCar);
	}

	@DeleteMapping("/cars/{carId}")
	public void deleteCar(@PathVariable String carId) {
		vehicleService.deleteCar(carId);
	}

	@GetMapping
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
	}
}
