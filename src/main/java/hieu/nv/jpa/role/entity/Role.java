package hieu.nv.jpa.role.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hieu.nv.jpa.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "system_name")
	private String systemName;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	@JsonBackReference
	@ToString.Exclude
	private List<User> users;
}

