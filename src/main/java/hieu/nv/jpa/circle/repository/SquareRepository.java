package hieu.nv.jpa.circle.repository;

import hieu.nv.jpa.circle.entity.Square;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquareRepository extends JpaRepository<Square, String> {
}