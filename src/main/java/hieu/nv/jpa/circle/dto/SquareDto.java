package hieu.nv.jpa.circle.dto;

import hieu.nv.jpa.circle.entity.Square;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Square}
 */
@Value
public class SquareDto implements Serializable {
    String id;
    String colorId;
    String colorName;
    double sideLength;
}