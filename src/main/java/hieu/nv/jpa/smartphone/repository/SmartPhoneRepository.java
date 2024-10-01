package hieu.nv.jpa.smartphone.repository;

import hieu.nv.jpa.smartphone.entity.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepository extends JpaRepository<SmartPhone, String> {
}