package hieu.nv.jpa.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "h_groups")
public class Group {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "created_at")
	private Date createdAt;

	@ManyToMany(mappedBy = "h_groups", fetch = FetchType.LAZY)
	@ToString.Exclude
	@JsonBackReference
	private List<User> users;

}
