package hieu.nv.jpa.course.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "title")
    private String title;

    @JsonManagedReference
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private CourseDetails courseDetails;
}
