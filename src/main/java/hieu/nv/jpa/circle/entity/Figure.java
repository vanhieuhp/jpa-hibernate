package hieu.nv.jpa.circle.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@MappedSuperclass
public abstract class Figure {

    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    @JoinColumn(name = "color_id")
    protected Color color;
}
