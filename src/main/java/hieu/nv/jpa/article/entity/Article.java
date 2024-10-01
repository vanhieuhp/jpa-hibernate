package hieu.nv.jpa.article.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@BatchSize(size=2)
@Table(name = "articles")
public class Article {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Embedded
	private Vote vote;

	@JsonIgnore // Avoid circular reference
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	private Author author;

	@PostPersist
	public void postPersist() {
		System.out.println("Article with ID: " + id + " has been persisted");
	}
}
