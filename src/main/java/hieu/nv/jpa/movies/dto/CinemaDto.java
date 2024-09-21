package hieu.nv.jpa.movies.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * DTO for {@link hieu.nv.jpa.movies.entity.Cinema}
 */
@Value
public class CinemaDto implements Serializable {
    String id;
    String name;
}