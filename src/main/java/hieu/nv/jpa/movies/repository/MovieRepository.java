package hieu.nv.jpa.movies.repository;

import hieu.nv.jpa.movies.dto.MovieDto;
import hieu.nv.jpa.movies.entity.Movie;
import hieu.nv.jpa.movies.projection.MovieBigProjection;
import hieu.nv.jpa.movies.projection.MovieSmallProjection;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {


	@QueryHints(value = {
			@QueryHint(name = "javax.persistence.lock.timeout", value = "5000"), // 5 seconds
			@QueryHint(name = "javax.persistence.query.timeout", value = "20"), // 3 seconds
			@QueryHint(name = "org.hibernate.fetchSize", value = "1000"),         // 50 rows
			@QueryHint(name = "org.hibernate.cacheable", value = "true"), // enable caching
//			@QueryHint(name = "org.hibernate.cacheRegion", value = "queryCacheRegion"), // cache region
//			@QueryHint(name = "jakarta.persistence.cache.retrieveMode", value = "USE"), // use cache
//			@QueryHint(name = "jakarta.persistence.cache.storeMode", value = "USE"), // use cache
//			@QueryHint(name = "org.hibernate.comment", value = "Find all movies by year"), // comment
//			@QueryHint(name = "org.hibernate.readOnly", value = "true"), // read-only
	})
	List<Movie> findAllByYear(String year);

    @Query("SELECT m FROM Movie m WHERE m.genre = :genre")
    List<MovieSmallProjection> findAllByGenreProjection(String genre);

    @Query("SELECT m FROM Movie m WHERE m.genre = :genre")
    List<MovieBigProjection> findAllByGenreV3(String genre);

    @Query("SELECT new hieu.nv.jpa.movies.dto.MovieDto(m.id, m.title) " +
            "FROM Movie m WHERE m.genre = :genre")
    List<MovieDto> findAllByGenreV1(String genre);

    @Query("SELECT new hieu.nv.jpa.movies.dto.MovieDto(m.id, m.title, m.genre) " +
            "FROM Movie m WHERE m.genre = :genre")
    List<MovieDto> findAllByGenreLittleField(String genre);

    @Query("SELECT m FROM Movie m WHERE m.genre = :genre")
    List<Movie> findAllByGenreAllField(String genre);

    @Query("SELECT m FROM Movie m")
    List<Movie> findAllMovies();

}