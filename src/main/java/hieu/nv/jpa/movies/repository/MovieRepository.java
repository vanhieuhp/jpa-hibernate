package hieu.nv.jpa.movies.repository;

import hieu.nv.jpa.movies.dto.MovieDto;
import hieu.nv.jpa.movies.entity.Movie;
import hieu.nv.jpa.movies.projection.MovieBigProjection;
import hieu.nv.jpa.movies.projection.MovieSmallProjection;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie, String>, JpaSpecificationExecutor<Movie> {

//    @QueryHints(value = {
//            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
//    })
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

//    @QueryHints(value = {
//            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
//    })
    @Query("SELECT m FROM Movie m")
    List<Movie> findAllMovies();

}