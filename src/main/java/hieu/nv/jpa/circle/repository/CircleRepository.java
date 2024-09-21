package hieu.nv.jpa.circle.repository;

import hieu.nv.jpa.circle.entity.Circle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircleRepository extends JpaRepository<Circle, String> {
}