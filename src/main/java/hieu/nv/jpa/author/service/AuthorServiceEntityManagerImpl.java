package hieu.nv.jpa.author.service;

import hieu.nv.jpa.article.entity.Article;
import hieu.nv.jpa.author.entity.Author;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorServiceEntityManagerImpl {

	private final EntityManager entityManager;

	// Persists the author and cascades to articles
	@Transactional
	public void persistAuthorAndArticles(Author author) {
		entityManager.persist(author);
	}

	// Merges the author and cascades to articles
	@Transactional
	public void mergeAuthorAndArticles(Author author) {
		entityManager.merge(author);
	}

	// Removes the author and cascades to articles
	@Transactional
	public void removeAuthorAndArticles(Author author) {
		entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
	}

	// Refreshes the author and cascades to articles
	@Transactional
	public void refreshAuthor(Author author) {
		entityManager.refresh(author);
	}

	// Detaches the author and cascades to articles
	@Transactional
	public void detachAuthor(Author author) {
		entityManager.detach(author);
	}

	// Example method to demonstrate orphanRemoval
	@Transactional
	public void removeArticleFromAuthor(Author author, Article article) {
		author.getArticles().remove(article);
		if (!entityManager.contains(author)) {
			// Merges the author, which cascades the removal of the orphaned article
			entityManager.merge(author);
		}
	}


}
