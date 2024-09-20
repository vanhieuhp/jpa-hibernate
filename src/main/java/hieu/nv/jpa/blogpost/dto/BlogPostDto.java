package hieu.nv.jpa.blogpost.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link hieu.nv.jpa.blogpost.entity.BlogPost}
 */
public record BlogPostDto(Long id, String title, Date createAt) implements Serializable {
}