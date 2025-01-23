package hieu.nv.jpa.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "users_languages")
@Data
public class Language {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "name")
	private String name;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
