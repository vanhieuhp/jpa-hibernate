package hieu.nv.jpa.circle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "colors")
@Data
public class Color {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "name")
    private String name;
}
