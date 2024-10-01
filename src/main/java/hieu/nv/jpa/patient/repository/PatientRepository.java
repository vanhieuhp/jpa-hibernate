package hieu.nv.jpa.patient.repository;

import hieu.nv.jpa.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {
}