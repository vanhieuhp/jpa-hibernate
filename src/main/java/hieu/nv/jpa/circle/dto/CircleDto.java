package hieu.nv.jpa.circle.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link hieu.nv.jpa.circle.entity.Circle}
 */
@Value
public class CircleDto implements Serializable {
    String id;
    String colorId;
    String colorName;
    double radius;
}