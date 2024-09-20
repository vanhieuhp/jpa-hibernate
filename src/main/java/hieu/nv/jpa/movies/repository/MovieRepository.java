package hieu.nv.jpa.movies.repository;

import hieu.nv.jpa.movies.entity.Movie;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, String>, JpaSpecificationExecutor<Movie> {

//	@QueryHints(value = {
//			@QueryHint(name = "javax.persistence.lock.timeout", value = "5000"),
//			@QueryHint(name = "javax.persistence.query.timeout", value = "3000"),
//			@QueryHint(name = "org.hibernate.fetchSize", value = "50"),
//			@QueryHint(name = "org.hibernate.cacheable", value = "true"),
//			@QueryHint(name = "org.hibernate.cacheRegion", value = "queryCacheRegion"),
//			@QueryHint(name = "javax.persistence.cache.retrieveMode", value = "USE"),
//			@QueryHint(name = "javax.persistence.cache.storeMode", value = "USE")
//	})
	List<Movie> findAllByYear(String year);
}