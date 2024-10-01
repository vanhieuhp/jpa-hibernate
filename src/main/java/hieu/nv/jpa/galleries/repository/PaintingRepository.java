package hieu.nv.jpa.galleries.repository;

import hieu.nv.jpa.galleries.entity.Painting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintingRepository extends JpaRepository<Painting, String> {
}