package hieu.nv.jpa.article.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequest {

	private Integer authorAge;
	private String authorName;
	private String title;
	private String content;
	private String review;
	private Integer rate;
}
