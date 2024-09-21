package hieu.nv.jpa.circle.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Circle")
@AssociationOverride(name="color", joinColumns=@JoinColumn(name="circle_color_id"))
@Table(name = "circles")
public class Circle extends Figure {

    @Column(name = "radius")
    private double radius;
}
