package hieu.nv.jpa.circle.service;

import hieu.nv.jpa.circle.dto.CircleDto;
import hieu.nv.jpa.circle.dto.SquareDto;
import hieu.nv.jpa.circle.entity.Circle;
import hieu.nv.jpa.circle.entity.Square;

public interface FigureService {
    Circle createCircle(CircleDto circle);

    Circle getCircle(String id);

    Circle updateCircle(String id, CircleDto circle);

    Iterable<Circle> getAllCircles();

    void deleteCircle(String id);

    Square createSquare(SquareDto square);
}
