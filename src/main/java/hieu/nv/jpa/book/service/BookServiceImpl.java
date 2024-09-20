package hieu.nv.jpa.book.service;

import hieu.nv.jpa.book.dto.BookDto;
import hieu.nv.jpa.book.entity.Book;
import hieu.nv.jpa.book.entity.BookContent;
import hieu.nv.jpa.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	@Override
	@Transactional
	public Book createBook(BookDto bookDto) {
		Book entity = new Book();
		entity.setTitle(bookDto.getTitle());
		bookRepository.save(entity);

		BookContent content = new BookContent();
		content.setContent(bookDto.getContent());
		content.setBook(entity);

		entity.setBookContent(content);
		return entity;
	}

	@Override
	public Book getBook(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public Iterable<Book> getAllBooks() {
		return bookRepository.findAll();
	}
}
