package hieu.nv.jpa.book.repository;

import hieu.nv.jpa.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}