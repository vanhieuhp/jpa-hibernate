package hieu.nv.jpa.article.controller;

import hieu.nv.jpa.article.dto.ArticleRequest;
import hieu.nv.jpa.article.entity.Article;
import hieu.nv.jpa.article.projection.ArticleTitleAndAuthorProjection;
import hieu.nv.jpa.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

	private final ArticleService articleService;

	@PostMapping
	public ResponseEntity<Article> createArticle(@RequestBody ArticleRequest articleRequest) {
		Article article = articleService.createArticle(articleRequest);
		return ResponseEntity.ok(article);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable String id) {
		Article article = articleService.getArticleById(id);
		return ResponseEntity.ok(article);
	}

	@GetMapping
	public ResponseEntity<List<Article>> getAllArticles() {
		List<Article> articles = articleService.getAllArticles();
		return ResponseEntity.ok(articles);
	}

	@GetMapping("/projection")
	public ResponseEntity<List<ArticleTitleAndAuthorProjection>> getAllArticlesWithProject() {
		List<ArticleTitleAndAuthorProjection> articles = articleService.getAllArticlesWithProject();
		return ResponseEntity.ok(articles);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable String id, @RequestBody ArticleRequest articleRequest) {
		Article article = articleService.updateArticle(id, articleRequest);
		return ResponseEntity.ok(article);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable String id) {
		articleService.deleteArticle(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/authors")
	public ResponseEntity<List<Article>> getByAuthorName(@RequestParam(name = "name") String authorName) {
		List<Article> articles = articleService.getByAuthorName(authorName);
		return ResponseEntity.ok(articles);
	}

}
