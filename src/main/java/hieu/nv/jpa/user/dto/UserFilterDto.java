package hieu.nv.jpa.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserFilterDto extends FilterDto {

	private String username;
	private Set<String> groups;
}
