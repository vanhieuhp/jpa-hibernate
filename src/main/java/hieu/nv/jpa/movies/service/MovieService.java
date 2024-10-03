package hieu.nv.jpa.movies.service;

import hieu.nv.jpa.movies.dto.MovieRequest;
import hieu.nv.jpa.movies.entity.Movie;

import java.util.List;

public interface MovieService {

	Movie createMovie(MovieRequest movie);

	Movie getMovieById(String id);

	Movie updateMovie(String id, MovieRequest movie);

	void deleteMovie(String id);

	List<Movie> getAllMovies();

	List<Movie> getAllMoviesByYear(String year);

	List<?> getAllByGenre(String genre);
}
