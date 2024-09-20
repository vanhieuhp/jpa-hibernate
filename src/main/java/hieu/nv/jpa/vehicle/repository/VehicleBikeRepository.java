package hieu.nv.jpa.vehicle.repository;

import hieu.nv.jpa.vehicle.entity.VehicleBike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleBikeRepository extends JpaRepository<VehicleBike, String> {
}
