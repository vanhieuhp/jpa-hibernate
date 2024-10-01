package hieu.nv.jpa.smartphone.repository;

import hieu.nv.jpa.smartphone.entity.Iphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IphoneRepository extends JpaRepository<Iphone, String> {
}