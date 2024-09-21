package hieu.nv.jpa.movies.service;

import hieu.nv.jpa.movies.dto.CinemaDto;
import hieu.nv.jpa.movies.entity.Cinema;
import hieu.nv.jpa.movies.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    @Override
    public Object createCinema(CinemaDto cinemaDto) {
        Cinema cinema = new Cinema();
        cinema.setName(cinemaDto.getName());
        return cinemaRepository.save(cinema);
    }

    @Override
    public Object getCinemaById(String id) {
        return cinemaRepository.findById(id);
    }

    @Override
    public Object getAllCinemas() {
        return cinemaRepository.findAll();
    }
}
