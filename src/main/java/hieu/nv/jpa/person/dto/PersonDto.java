package hieu.nv.jpa.person.dto;

import lombok.Data;

/**
 * DTO for {@link hieu.nv.jpa.person.entity.Person}
 */
@Data
public class PersonDto {
	private String id;
	private String username;
	private String email;
	private String phoneNumber;
}