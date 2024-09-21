package hieu.nv.jpa.movies.controller;

import hieu.nv.jpa.movies.dto.CinemaDto;
import hieu.nv.jpa.movies.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    @PostMapping
    public ResponseEntity<?> createCinema(@RequestBody CinemaDto cinemaDto) {
        return ResponseEntity.ok(cinemaService.createCinema(cinemaDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCinemaById(@PathVariable String id) {
        return ResponseEntity.ok(cinemaService.getCinemaById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllCinemas() {
        return ResponseEntity.ok(cinemaService.getAllCinemas());
    }
}
