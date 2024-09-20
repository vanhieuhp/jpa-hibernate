package hieu.nv.jpa.article.projection;

import hieu.nv.jpa.author.projection.AuthorProjection;

public interface ArticleTitleAndAuthorProjection {

	String getId();
	String getTitle();
	AuthorProjection getAuthor(); // Using nested projection
}
