package hieu.nv.jpa.movies.dto;

import lombok.Data;

@Data
public class MovieRequest  {
	private String title;
	private String genre;
	private String year;
}