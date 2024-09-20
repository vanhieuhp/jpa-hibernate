package hieu.nv.jpa.blogpost.service;

import hieu.nv.jpa.blogpost.dto.BlogPostDto;
import hieu.nv.jpa.blogpost.entity.BlogPost;
import hieu.nv.jpa.blogpost.repository.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {

	private final BlogPostRepository blogPostRepository;

	@Override
	@Transactional
	public BlogPost createBlogPost(BlogPostDto blogPost) {
		BlogPost entity = new BlogPost();
		entity.setTitle(blogPost.title());
		entity.setDate(new Date());
		entity.setTime(new Date());
		entity.setTimestampDate(new Date());
		blogPostRepository.save(entity);

		return entity;
	}

	@Override
	public BlogPost getBlogPost(Long id) {
		return blogPostRepository.findById(id).orElse(null);
	}

	@Override
	public List<BlogPost> getAllBlogPosts() {
		return blogPostRepository.findAll();
	}
}
