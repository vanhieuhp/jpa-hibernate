package hieu.nv.jpa.galleries.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Builder
@ToString(exclude = "gallery")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paintings")
public class Painting {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "artist")
	private String artist;

	@Embedded
	private ArtStyle style;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gallery_id")
	@JsonBackReference
	private Gallery gallery;
}
