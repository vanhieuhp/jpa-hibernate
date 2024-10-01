package hieu.nv.jpa.galleries.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@Builder
@ToString(exclude = "paintings")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "galleries")
public class Gallery {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@MapKeyClass(ArtStyle.class)
	@BatchSize(size = 10) // for prevent N+1 problem
	@JsonManagedReference
	private Map<ArtStyle, Painting> paintings = new HashMap<>();
}
