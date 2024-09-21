package hieu.nv.jpa.circle.controller;

import hieu.nv.jpa.circle.dto.CircleDto;
import hieu.nv.jpa.circle.dto.SquareDto;
import hieu.nv.jpa.circle.entity.Circle;
import hieu.nv.jpa.circle.entity.Square;
import hieu.nv.jpa.circle.service.FigureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/figures")
@RequiredArgsConstructor
public class FigureController {

    private final FigureService figureService;

    @PostMapping("/circles")
    public ResponseEntity<Circle> createCircle(@RequestBody CircleDto circle) {
        return ResponseEntity.ok(figureService.createCircle(circle));
    }

    @GetMapping("/circles/{id}")
    public ResponseEntity<Circle> getCircle(@PathVariable String id) {
        return ResponseEntity.ok(figureService.getCircle(id));
    }

    @PutMapping("/circles/{id}")
    public ResponseEntity<Circle> updateCircle(@PathVariable String id, @RequestBody CircleDto circle) {
        return ResponseEntity.ok(figureService.updateCircle(id, circle));
    }

    @DeleteMapping("/circles/{id}")
    public ResponseEntity<Void> deleteCircle(@PathVariable String id) {
        figureService.deleteCircle(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/circles")
    public ResponseEntity<Iterable<Circle>> getAllCircles() {
        return ResponseEntity.ok(figureService.getAllCircles());
    }

    @PostMapping("/squares")
    public ResponseEntity<Square> createCircle(@RequestBody SquareDto square) {
        return ResponseEntity.ok(figureService.createSquare(square));
    }
}
