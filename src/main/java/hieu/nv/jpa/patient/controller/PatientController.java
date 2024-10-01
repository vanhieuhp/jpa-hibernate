package hieu.nv.jpa.patient.controller;

import hieu.nv.jpa.patient.dto.PatientDto;
import hieu.nv.jpa.patient.entity.Patient;
import hieu.nv.jpa.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

	private final PatientService patientService;

	@PostMapping
	public ResponseEntity<Patient> createPatient(@RequestBody PatientDto patientDto) {
		return ResponseEntity.ok(patientService.createPatient(patientDto));
	}

	@GetMapping
	public ResponseEntity<List<Patient>> getPatients() {
		return ResponseEntity.ok(patientService.getPatients());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
		return ResponseEntity.ok(patientService.getPatient(id));
	}
}
