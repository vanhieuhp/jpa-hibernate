package hieu.nv.jpa.circle.service;

import hieu.nv.jpa.circle.dto.CircleDto;
import hieu.nv.jpa.circle.dto.SquareDto;
import hieu.nv.jpa.circle.entity.Circle;
import hieu.nv.jpa.circle.entity.Color;
import hieu.nv.jpa.circle.entity.Square;
import hieu.nv.jpa.circle.repository.CircleRepository;
import hieu.nv.jpa.circle.repository.ColorRepository;
import hieu.nv.jpa.circle.repository.SquareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FigureServiceImpl implements FigureService {

    private final CircleRepository circleRepository;
    private final ColorRepository colorRepository;
    private final SquareRepository squareRepository;

    @Override
    public Circle createCircle(CircleDto circle) {
        Circle newCircle = new Circle();

        Color color = new Color();
        color.setName(circle.getColorName());
        colorRepository.save(color);

        newCircle.setColor(color);
        newCircle.setRadius(circle.getRadius());
        return circleRepository.save(newCircle);

    }

    @Override
    public Circle getCircle(String id) {
        return circleRepository.findById(id).orElse(null);
    }

    @Override
    public Circle updateCircle(String id, CircleDto circle) {
        Circle updatedCircle = circleRepository.findById(id).orElse(null);
        if (updatedCircle == null) {
            return null;
        }
        updatedCircle.setRadius(circle.getRadius());
        Color color = new Color();
        color.setName(circle.getColorName());
        updatedCircle.setColor(color);
        return circleRepository.save(updatedCircle);
    }

    @Override
    public Iterable<Circle> getAllCircles() {
        return circleRepository.findAll();
    }

    @Override
    public void deleteCircle(String id) {
        circleRepository.deleteById(id);
    }

    @Override
    public Square createSquare(SquareDto square) {
        Square newSquare = new Square();

        Color color = new Color();
        color.setName(square.getColorName());
        colorRepository.save(color);

        newSquare.setColor(color);
        newSquare.setSideLength(square.getSideLength());
        return squareRepository.save(newSquare);
    }
}
