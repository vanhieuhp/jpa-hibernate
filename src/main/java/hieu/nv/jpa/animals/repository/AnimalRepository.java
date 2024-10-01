package hieu.nv.jpa.animals.repository;

import hieu.nv.jpa.animals.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, String> {
}