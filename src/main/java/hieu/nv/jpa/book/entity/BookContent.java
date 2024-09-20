package hieu.nv.jpa.book.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "book")
@Table(name = "book_contents")
public class BookContent {

//	@Id
//	@GeneratedValue(
//			strategy = GenerationType.SEQUENCE,
//			generator = "book_contents_id_seq"
//	)
//	@SequenceGenerator(
//			name = "book_contents_id_seq",
//			sequenceName = "book_contents_id_seq",
//			allocationSize = 1
//	)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "book_contents_id_seq")
	@TableGenerator(
			name = "book_contents_id_seq",
			table = "id_generator_table",
			pkColumnName = "gen_name",
			valueColumnName = "gen_value",
			pkColumnValue = "book_contents_id_seq",
			allocationSize = 1
	)
	private Long id;


	@Lob
	@Column(name = "content", columnDefinition = "LONGTEXT")
	private String content;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	private Book book;
}


