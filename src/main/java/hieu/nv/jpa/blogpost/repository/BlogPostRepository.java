package hieu.nv.jpa.blogpost.repository;

import hieu.nv.jpa.blogpost.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}