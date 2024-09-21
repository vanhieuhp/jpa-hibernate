package hieu.nv.jpa.circle.repository;

import hieu.nv.jpa.circle.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, String> {
}