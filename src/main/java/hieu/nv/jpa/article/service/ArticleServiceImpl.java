package hieu.nv.jpa.article.service;

import hieu.nv.jpa.article.dto.ArticleRequest;
import hieu.nv.jpa.article.entity.Article;
import hieu.nv.jpa.article.projection.ArticleTitleAndAuthorProjection;
import hieu.nv.jpa.article.repository.ArticleRepository;
import hieu.nv.jpa.random.RandomStringService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

	private final ArticleRepository articleRepository;
//	@PersistenceUnit
//	private EntityManagerFactory emf;

	private final EntityManager entityManager;

	private final RandomStringService randomStringSv;

	@Override
	@Transactional
	public Article createArticle(ArticleRequest articleRequest) {

//		EntityManager entityManager = emf.createEntityManager();
//		EntityTransaction txn = em.getTransaction();
//		txn.begin();
//		em.persist(account);
//		txn.commit();
//		em.close();


//		Author author = new Author();
//		author.setName(articleRequest.getAuthorName());
//		author.setAge(articleRequest.getAuthorAge());
//
//
//		Article article = new Article();
//		article.setTitle(articleRequest.getTitle());
//		article.setContent(articleRequest.getContent());
//		article.setAuthor(author);
//		return articleRepository.save(article);

//		Author author = new Author("John Doe");
		String randomString = randomStringSv.generateRandomString(6);
		Article article = new Article();
		article.setTitle("Hello JPA " + randomString);
		article.setContent("This is a sample article");
//		author.getArticles().add(article);
//		entityManager.persist(author);
//		entityManager.merge(author);
		entityManager.persist(article);
		return article;
	}

	@Override
	public Article getArticleById(String id) {
		return articleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	@Override
	public Article updateArticle(String id, ArticleRequest articleRequest) {
		Optional<Article> optionalArticle = articleRepository.findById(id);
		if (optionalArticle.isPresent()) {
			Article article = optionalArticle.get();
			article.setTitle(articleRequest.getTitle());
			article.setContent(articleRequest.getContent());
			return articleRepository.save(article);
		}
		return null;
	}

	@Override
	public void deleteArticle(String id) {
		articleRepository.deleteById(id);
	}

	@Override
	public List<Article> getByAuthorName(String authorName) {
		return articleRepository.findByAuthorName(authorName);
	}

	@Override
	public List<ArticleTitleAndAuthorProjection> getAllArticlesWithProject() {
		return articleRepository.findAllWithProject();
	}
}
