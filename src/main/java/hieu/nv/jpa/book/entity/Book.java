package hieu.nv.jpa.book.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString(exclude = "bookContent")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

//	@Lob
//	@Column(name = "content")
	@OneToOne(
			mappedBy = "book",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL
	)
	private BookContent bookContent; // Text content of the book
}
