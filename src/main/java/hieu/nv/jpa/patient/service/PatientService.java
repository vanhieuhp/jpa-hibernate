package hieu.nv.jpa.patient.service;

import hieu.nv.jpa.patient.dto.PatientDto;
import hieu.nv.jpa.patient.entity.Patient;

import java.util.List;

public interface PatientService {
	Patient createPatient(PatientDto patientDto);

	List<Patient> getPatients();

	Patient getPatient(String id);
}
