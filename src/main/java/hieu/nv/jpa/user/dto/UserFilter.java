package hieu.nv.jpa.user.dto;

import hieu.nv.jpa.group.entity.Group;
import hieu.nv.jpa.role.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFilter {

	private String username;
	private Set<Role> roles;
	private Set<Group> h_groups;

	public Optional<String> getUsername() {
		return Optional.ofNullable(username);
	}

	public Optional<Set<Group>> getGroups() {
		return Objects.nonNull(h_groups) && !h_groups.isEmpty()
		       ? Optional.of(h_groups)
		       : Optional.empty();
	}

	public Optional<Set<Role>> getRoles() {
		return Objects.nonNull(roles) && !roles.isEmpty()
		       ? Optional.of(roles)
		       : Optional.empty();
	}
}
