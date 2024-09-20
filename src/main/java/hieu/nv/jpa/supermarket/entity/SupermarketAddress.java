package hieu.nv.jpa.supermarket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class SupermarketAddress {

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;
}
