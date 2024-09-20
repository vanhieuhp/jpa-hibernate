package hieu.nv.jpa.author.service;

import hieu.nv.jpa.author.dto.AuthorDto;
import hieu.nv.jpa.author.dto.AuthorRequest;
import hieu.nv.jpa.author.entity.Author;
import hieu.nv.jpa.author.projection.AuthorProjection;

import java.util.List;

public interface AuthorService {

	Author saveAuthor(AuthorRequest author);
	Author updateAuthor(String authorId, AuthorRequest author);
    void deleteAuthor(String authorId);
    void removeArticleFromAuthor(String authorId, String articleId);
    Author getAuthorById(String authorId);
    List<Author> getAllAuthors();
	List<AuthorProjection> getAllAuthorsWithProjection();
	List<AuthorDto> getAllAuthorsWithDto();
	Author getArticleByIdWithSession(String id);
}
