package hieu.nv.jpa.book.dto;

import lombok.Data;

/**
 * DTO for {@link hieu.nv.jpa.book.entity.Book}
 */
@Data
public class BookDto {
	private Long id;
	private String title;
	private String content;
}