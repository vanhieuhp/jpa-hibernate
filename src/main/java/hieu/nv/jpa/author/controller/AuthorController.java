package hieu.nv.jpa.author.controller;

import hieu.nv.jpa.author.dto.AuthorDto;
import hieu.nv.jpa.author.dto.AuthorRequest;
import hieu.nv.jpa.author.entity.Author;
import hieu.nv.jpa.author.projection.AuthorProjection;
import hieu.nv.jpa.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

	private final AuthorService authorService;

	// Implement the RESTful API for the Author entity
	@GetMapping
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}

	@GetMapping("/projection")
	public List<AuthorProjection> getAllAuthorsWithProjection() {
		return authorService.getAllAuthorsWithProjection();
	}

	@GetMapping("/dto")
	public List<AuthorDto> getAllAuthorsWithDto() {
		return authorService.getAllAuthorsWithDto();
	}

	@GetMapping("/{authorId}")
	public Author getAuthorById(@PathVariable String authorId) {
		return authorService.getAuthorById(authorId);
	}

	@PostMapping
	public Author saveAuthor(@RequestBody AuthorRequest author) {
		return authorService.saveAuthor(author);
	}

	@PutMapping("/{authorId}")
	public Author updateAuthor(@PathVariable String authorId, @RequestBody AuthorRequest author) {
		return authorService.updateAuthor(authorId, author);
	}

	@DeleteMapping("/{authorId}")
	public void deleteAuthor(@PathVariable String authorId) {
		authorService.deleteAuthor(authorId);
	}

	@GetMapping("/{authorId}/session")
	public ResponseEntity<Author> getArticleByIdWithSession(@PathVariable String authorId) {
		Author article = authorService.getArticleByIdWithSession(authorId);
		return ResponseEntity.ok(article);
	}
}
