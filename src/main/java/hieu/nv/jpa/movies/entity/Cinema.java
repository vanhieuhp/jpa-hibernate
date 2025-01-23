package hieu.nv.jpa.movies.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cinemas")
public class Cinema {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "name")
    private String name;

//    @JsonManagedReference
//    @OneToMany(mappedBy="assignedCinema", fetch = FetchType.EAGER)
//    @MapKey(name="year")
//   private Map<String, Movie> movies
//    private List<Movie> movies;
}
