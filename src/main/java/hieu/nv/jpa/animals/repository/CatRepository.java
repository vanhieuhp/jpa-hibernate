package hieu.nv.jpa.animals.repository;

import hieu.nv.jpa.animals.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, String> {
}