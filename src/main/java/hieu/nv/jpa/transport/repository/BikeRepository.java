package hieu.nv.jpa.transport.repository;

import hieu.nv.jpa.transport.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, String> {
}