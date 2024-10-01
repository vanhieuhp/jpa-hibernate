package hieu.nv.jpa.patient.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String street;

	private String city;
}
