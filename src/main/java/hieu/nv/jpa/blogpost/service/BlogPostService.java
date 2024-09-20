package hieu.nv.jpa.blogpost.service;

import hieu.nv.jpa.blogpost.dto.BlogPostDto;
import hieu.nv.jpa.blogpost.entity.BlogPost;

import java.util.List;

public interface BlogPostService {
	BlogPost createBlogPost(BlogPostDto blogPost);

	BlogPost getBlogPost(Long id);

	List<BlogPost> getAllBlogPosts();
}
