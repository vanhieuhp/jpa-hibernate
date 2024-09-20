package hieu.nv.jpa.book.service;

import hieu.nv.jpa.book.dto.BookDto;
import hieu.nv.jpa.book.entity.Book;

public interface BookService {
	Book createBook(BookDto bookDto);

	Book getBook(Long id);

	Iterable<Book> getAllBooks();
}
