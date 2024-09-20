package hieu.nv.jpa.article.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hieu.nv.jpa.author.entity.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
@BatchSize(size=2)
public class Article {

	@Id
	@UuidGenerator
	private String id;

//	@Embedded
//	@JsonIgnore // Avoid circular reference
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	private Author author;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@PostPersist
	public void postPersist() {
		System.out.println("Article with ID: " + id + " has been persisted");
	}
}
