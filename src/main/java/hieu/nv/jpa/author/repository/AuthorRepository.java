package hieu.nv.jpa.author.repository;

import hieu.nv.jpa.author.dto.AuthorDto;
import hieu.nv.jpa.author.entity.Author;
import hieu.nv.jpa.author.projection.AuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String>, JpaSpecificationExecutor<Author> {

	@Query("SELECT a FROM Author a")
	List<AuthorProjection> findAllWithProject();

	@Query("SELECT new hieu.nv.jpa.author.dto.AuthorDto(a.id, a.age, a.name) FROM Author a")
	List<AuthorDto> findAllWithDto();
}