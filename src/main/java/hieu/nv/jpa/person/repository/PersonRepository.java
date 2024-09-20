package hieu.nv.jpa.person.repository;

import hieu.nv.jpa.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}