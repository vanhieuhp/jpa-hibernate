package hieu.nv.jpa.patient.dto;

import hieu.nv.jpa.patient.entity.Address;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Address}
 */
@Value
public class AddressDto implements Serializable {
	String street;
	String city;
}