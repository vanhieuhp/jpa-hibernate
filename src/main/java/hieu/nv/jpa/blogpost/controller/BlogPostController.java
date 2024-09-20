package hieu.nv.jpa.blogpost.controller;

import hieu.nv.jpa.blogpost.dto.BlogPostDto;
import hieu.nv.jpa.blogpost.entity.BlogPost;
import hieu.nv.jpa.blogpost.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog-posts")
@RequiredArgsConstructor
public class BlogPostController {

	private final BlogPostService blogPostService;

	@PostMapping
	public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPostDto blogPost) {
		return ResponseEntity.ok(blogPostService.createBlogPost(blogPost));
	}

	@GetMapping("/{id}")
	public ResponseEntity<BlogPost> getBlogPost(@PathVariable Long id) {
		return ResponseEntity.ok(blogPostService.getBlogPost(id));
	}

	@GetMapping
	public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
		return ResponseEntity.ok(blogPostService.getAllBlogPosts());
	}
}
