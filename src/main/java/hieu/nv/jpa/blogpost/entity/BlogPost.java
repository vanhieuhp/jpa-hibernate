package hieu.nv.jpa.blogpost.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blog_posts")

public class BlogPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "date")
	@Temporal(TemporalType.DATE) // Utilizing java.util.Date with the @Temporal annotation
	private Date date;


	@Column(name = "timestamp_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestampDate;

	@Column(name = "time")
	@Temporal(TemporalType.TIME)
	private Date time;
}
