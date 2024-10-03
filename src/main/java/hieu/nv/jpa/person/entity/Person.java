package hieu.nv.jpa.person.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.*;
import lombok.*;

//@DynamicInsert
//@DynamicUpdate
@Entity
@Data
@Table(name = "persons")
@SecondaryTable(
		name = "person_contacts",
		pkJoinColumns = @PrimaryKeyJoinColumn(name = "person_id")
)
public class Person {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "username")
	private String username;

	@Column(table = "person_contacts", name = "email")
	private String email;

	@Column(table = "person_contacts", name = "phone_number")
	private String phoneNumber;
}
