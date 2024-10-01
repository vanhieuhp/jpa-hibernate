package hieu.nv.jpa.animals.repository;

import hieu.nv.jpa.animals.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, String> {
}