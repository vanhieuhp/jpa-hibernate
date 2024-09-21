package hieu.nv.jpa.movies.service;

import hieu.nv.jpa.movies.dto.CinemaDto;

public interface CinemaService {
    Object createCinema(CinemaDto cinemaDto);

    Object getCinemaById(String id);

    Object getAllCinemas();
}
