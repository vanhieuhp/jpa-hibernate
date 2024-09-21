package hieu.nv.jpa.course.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link hieu.nv.jpa.course.entity.CourseDetails}
 */
@Value
public class CourseDetailsDto implements Serializable {
    String id;
    String description;
}