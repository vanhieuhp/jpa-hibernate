package hieu.nv.jpa.movies.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {

    private String id;
    private String title;
    private String genre;
    private String year;
    private String cinemaId;

    public MovieDto() {
    }

    public MovieDto(String id, String title, String genre, String year, String cinemaId) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.cinemaId = cinemaId;
    }

    public MovieDto(String id, String title, String genre, String year) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public MovieDto(String id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public MovieDto(String id, String title) {
        this.id = id;
        this.title = title;
    }
}
