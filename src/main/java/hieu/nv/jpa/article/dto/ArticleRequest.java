package hieu.nv.jpa.article.dto;

import lombok.Data;

@Data
public class ArticleRequest {

	private Integer authorAge;
	private String authorName;
	private String title;
	private String content;
}
