package hieu.nv.jpa.author.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hieu.nv.jpa.article.entity.Article;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@Embeddable
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@Entity
@Table(name = "authors")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Author {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@OrderBy("title DESC")
	@BatchSize(size=3)
	@OneToMany(
			mappedBy = "author",
			fetch = FetchType.LAZY,
			cascade = {CascadeType.ALL},
			orphanRemoval = true
	)
	@JsonManagedReference
	@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<Article> articles = new ArrayList<>();

	public Author(String name) {
		this.name = name;
	}
}
