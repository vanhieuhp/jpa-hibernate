package hieu.nv.jpa.author.service;

import hieu.nv.jpa.article.entity.Article;
import hieu.nv.jpa.article.repository.ArticleRepository;
import hieu.nv.jpa.author.dto.AuthorDto;
import hieu.nv.jpa.author.dto.AuthorRequest;
import hieu.nv.jpa.author.entity.Author;
import hieu.nv.jpa.author.projection.AuthorProjection;
import hieu.nv.jpa.author.repository.AuthorRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

	private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);
	private final EntityManager entityManager;
	private final AuthorRepository authorRepository;
	private final ArticleRepository articleRepository;

	@Override
	@Transactional
	public Author saveAuthor(AuthorRequest author) {
		Author newAuthor = new Author();
		newAuthor.setName(author.getName());
		newAuthor.setAge(author.getAge());

		Article article = new Article();
		article.setTitle("Hello JPA");
		article.setContent("This is a sample article");
		article.setAuthor(newAuthor);
		newAuthor.getArticles().add(article);

		authorRepository.save(newAuthor);
		return newAuthor;
	}

	@Override
	@Transactional
	public Author updateAuthor(String authorId, AuthorRequest author) {
		Author existingAuthor = authorRepository.findById(authorId).orElseThrow();
		existingAuthor.setName(author.getName());
		existingAuthor.setAge(author.getAge());

		return existingAuthor;
	}

	@Override
	@Transactional
	public void deleteAuthor(String authorId) {
		// Deleting an author along with its related entities due to cascade operations
		Author author = authorRepository.findById(authorId).orElseThrow();
//		author.getArticles().removeFirst();
//		author.setArticles(new ArrayList<>());
//		author.getArticles().removeIf(article -> article.getId().equals("9f24fcaf-745f-40bb-8719-62c9ccea989c"));
//		authorRepository.save(author);
		authorRepository.delete(author);
	}

	@Override
	@Transactional
	public void removeArticleFromAuthor(String authorId, String articleId) {
		// Orphan Removal: Removing an article from the author's collection
		Author author = authorRepository.findById(authorId).orElseThrow();
		author.getArticles().removeIf(article -> article.getId().equals(articleId));
		// The orphaned article will be deleted from the DB
		authorRepository.save(author);
	}

	@Override
	@Transactional(readOnly = true)
	public Author getAuthorById(String authorId) {
		Author author = authorRepository.findById(authorId)
				.orElseThrow(() -> new EntityNotFoundException("Author not found"));
//		author.getArticles().stream().map(Article::getTitle).forEach(System.out::println);
		String articleIds = author.getArticles().stream().map(Article::getId).findFirst().orElseThrow();
//		List<Article> results = session.createQuery("FROM Article WHERE id in :articleIds", Article.class)
//				.setParameter("articleIds", articleIds)
//				.setHint("org.hibernate.cacheable", true).getResultList();
//		author.setArticles(results);

		SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
		Session curSession1 = sessionFactory.openSession();
		Author author1 = curSession1.get(Author.class, authorId);
		return author;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();

	}

	@Override
	public List<AuthorProjection> getAllAuthorsWithProjection() {
		// Fetching the authors along with their articles
		return authorRepository.findAllWithProject();
	}

	@Override
	public List<AuthorDto> getAllAuthorsWithDto() {
		return authorRepository.findAllWithDto();
	}

	@Override
	public Author getArticleByIdWithSession(String id) {
		SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
		Session session = sessionFactory.openSession();

		/* Try access to lazy loaded articles after session has been closed
		*/
//		Author author = session.get(Author.class, id);
//		session.close();
//		if (author == null) {
//			throw new EntityNotFoundException("Author not found");
//		}
//		int articlesSize = author.getArticles().size(); // throw LazyInitializationException

		/* Get Author without open transaction
		 */
		Author author = null;
//		try {
//			author = session.get(Author.class, id);
//			// Get Author without open transaction
//			// Try init without transaction
//			int articlesSize = author.getArticles().size();
//		} catch (Exception e) {
//			log.error("Error: {}", e.getMessage());
//		}

//		try {
//			Transaction tx = session.beginTransaction();
//			author = session.get(Author.class, id);
//
//			// Try init with transaction
//			int articlesSize = author.getArticles().size();
//			System.out.println("Articles size: " + articlesSize);
//			tx.commit();
//		} catch (Exception e) {
//			log.error("Error: {}", e.getMessage());
//		} finally {
//			session.close();
//		}

		/* Using Graph */
		EntityGraph<Author> graph = entityManager.createEntityGraph(Author.class);
		graph.addAttributeNodes("articles");
		Map<String, Object> hints = new HashMap<>();
		hints.put("javax.persistence.loadgraph", graph);
		author = entityManager.find(Author.class, id, hints);
 		return author;
	}
}
