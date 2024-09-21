package hieu.nv.jpa.course.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course_details")
public class CourseDetails {

    @Id
    private String id;

    @Column(name = "description")
    private String description;

    @JsonBackReference
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Course course;

}
