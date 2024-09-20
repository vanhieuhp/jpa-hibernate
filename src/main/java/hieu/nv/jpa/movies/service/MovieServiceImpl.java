package hieu.nv.jpa.movies.service;

import hieu.nv.jpa.movies.dto.MovieRequest;
import hieu.nv.jpa.movies.entity.Movie;
import hieu.nv.jpa.movies.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("movieService")
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;

	@Override
	public Movie createMovie(MovieRequest movie) {
		Movie newMovie = new Movie();
		newMovie.setTitle(movie.getTitle());
		newMovie.setGenre(movie.getGenre());
		newMovie.setYear(movie.getYear());
		return movieRepository.save(newMovie);
	}

	@Override
	public Movie getMovieById(String id) {
		Optional<Movie> movie = movieRepository.findById(id);
		return movie.orElse(null);
	}

	@Override
	@Transactional
	public Movie updateMovie(String id, MovieRequest movie) {
		Movie existingMovie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		existingMovie.setTitle(movie.getTitle());
		existingMovie.setGenre(movie.getGenre());
		existingMovie.setYear(movie.getYear());
		return existingMovie;
	}

	@Override
	public void deleteMovie(String id) {
		movieRepository.deleteById(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public List<Movie> getAllMoviesByYear(String year) {
		return movieRepository.findAllByYear(year);
	}
}
