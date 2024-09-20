package hieu.nv.jpa.vehicle.repository;

import hieu.nv.jpa.vehicle.entity.VehicleCar;
import hieu.nv.jpa.vehicle.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

	@Query("SELECT v FROM VehicleCar v WHERE TYPE(v) = VehicleCar")
	List<VehicleCar> findAllCars();
}

