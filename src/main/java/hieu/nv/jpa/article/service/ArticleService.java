package hieu.nv.jpa.article.service;

import hieu.nv.jpa.article.dto.ArticleRequest;
import hieu.nv.jpa.article.entity.Article;
import hieu.nv.jpa.article.projection.ArticleTitleAndAuthorProjection;

import java.util.List;

public interface ArticleService {
	Article createArticle(ArticleRequest articleRequest);

	Article getArticleById(String id);

	List<Article> getAllArticles();

	Article updateArticle(String id, ArticleRequest articleRequest);

	void deleteArticle(String id);

	List<Article> getByAuthorName(String authorName);

	List<ArticleTitleAndAuthorProjection> getAllArticlesWithProject();

	List<Article> getByVoteRate(ArticleRequest request);
}
