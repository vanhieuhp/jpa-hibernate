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
@DiscriminatorValue("Square")
@AssociationOverride(name = "color", joinColumns = @JoinColumn(name = "square_color_id"))
@Table(name = "squares")
public class Square extends Figure {

    @Column(name = "side_length")
    private double sideLength;
}


