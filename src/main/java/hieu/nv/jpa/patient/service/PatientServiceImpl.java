package hieu.nv.jpa.patient.service;

import hieu.nv.jpa.patient.dto.PatientDto;
import hieu.nv.jpa.patient.entity.Patient;
import hieu.nv.jpa.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

	private final PatientRepository patientRepository;

	@Override
	@Transactional
	public Patient createPatient(PatientDto patientDto) {
		Patient patient = new Patient();
		patient.setName(patientDto.getName());
		patient.setPermanentAddress(patientDto.getPermanentAddress());
		patient.setTemporaryAddress(patientDto.getTemporaryAddress());
		patientRepository.save(patient);
		return patient;
	}

	@Override
	public List<Patient> getPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatient(String id) {
		return patientRepository.findById(id).orElse(null);
	}
}
