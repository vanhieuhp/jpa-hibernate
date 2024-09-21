package hieu.nv.jpa.movies.repository;

import hieu.nv.jpa.movies.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, String> {
}