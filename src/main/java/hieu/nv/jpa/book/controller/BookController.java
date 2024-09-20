package hieu.nv.jpa.book.controller;

import hieu.nv.jpa.book.dto.BookDto;
import hieu.nv.jpa.book.entity.Book;
import hieu.nv.jpa.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;

	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody BookDto bookDto) {
		Book book = bookService.createBook(bookDto);
		return ResponseEntity.ok(book);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id) {
		Book book = bookService.getBook(id);
		if (book != null) {
			return ResponseEntity.ok(book);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<Iterable<Book>> getAllBooks() {
		Iterable<Book> books = bookService.getAllBooks();
		return ResponseEntity.ok(books);
	}
}
