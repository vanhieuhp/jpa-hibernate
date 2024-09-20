package hieu.nv.jpa.article.repository;

import hieu.nv.jpa.article.entity.Article;
import hieu.nv.jpa.article.projection.ArticleTitleAndAuthorProjection;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("articleRepository")
//@Transactional
public interface ArticleRepository extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {

	@QueryHints(value = {
			@QueryHint(name = "javax.persistence.lock.timeout", value = "5000"),
			@QueryHint(name = "javax.persistence.query.timeout", value = "3000"),
			@QueryHint(name = "org.hibernate.fetchSize", value = "50"),
			@QueryHint(name = "org.hibernate.cacheable", value = "true"),
			@QueryHint(name = "org.hibernate.cacheRegion", value = "queryCacheRegion"),
			@QueryHint(name = "javax.persistence.cache.retrieveMode", value = "USE"),
			@QueryHint(name = "javax.persistence.cache.storeMode", value = "USE")
	})
	@Query("SELECT a FROM Article a WHERE a.author.name = :name")
	List<Article> findByAuthorName(@Param("name") String name);

	@Query("SELECT a FROM Article a WHERE a.author.age = :age")
	List<Article> findByAuthorLogin(@Param("age") String age);

	@Query("SELECT a FROM Article a")
	List<ArticleTitleAndAuthorProjection> findAllWithProject();
}
