package hieu.nv.jpa.transport.repository;

import hieu.nv.jpa.transport.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}