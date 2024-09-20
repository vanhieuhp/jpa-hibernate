package hieu.nv.jpa.vehicle.repository;

import hieu.nv.jpa.vehicle.entity.VehicleCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCarRepository extends JpaRepository<VehicleCar, String> {
}
