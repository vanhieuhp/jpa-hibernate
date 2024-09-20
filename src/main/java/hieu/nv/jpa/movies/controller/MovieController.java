package hieu.nv.jpa.movies.controller;

import hieu.nv.jpa.movies.dto.MovieRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import hieu.nv.jpa.movies.entity.Movie;
import hieu.nv.jpa.movies.service.MovieService;
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

	private final MovieService movieService;

	@PostMapping
	public Movie createMovie(@RequestBody MovieRequest movie) {
		return movieService.createMovie(movie);
	}

	@GetMapping("/{id}")
	public Movie getMovieById(@PathVariable String id) {
		return movieService.getMovieById(id);
	}

	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable String id, @RequestBody MovieRequest movie) {
		return movieService.updateMovie(id, movie);
	}

	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable String id) {
		movieService.deleteMovie(id);
	}

	@GetMapping
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@GetMapping("/filter")
	public List<Movie> getAllMoviesByYear(@RequestParam(name = "year") String year) {
		return movieService.getAllMoviesByYear(year);
	}
}
