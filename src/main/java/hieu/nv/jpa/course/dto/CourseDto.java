package hieu.nv.jpa.course.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link hieu.nv.jpa.course.entity.Course}
 */
@Value
public class CourseDto implements Serializable {
    String id;
    String title;
    CourseDetailsDto courseDetails;
}