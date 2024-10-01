package hieu.nv.jpa.patient.dto;

import hieu.nv.jpa.patient.entity.Address;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link hieu.nv.jpa.patient.entity.Patient}
 */
@Value
public class PatientDto implements Serializable {
	String id;
	String name;
	Address permanentAddress;
	Address temporaryAddress;
}