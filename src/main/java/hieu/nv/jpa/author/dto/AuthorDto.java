package hieu.nv.jpa.author.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {
	private String id;
	private int age;
	private String name;

	public AuthorDto(String id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}
}
