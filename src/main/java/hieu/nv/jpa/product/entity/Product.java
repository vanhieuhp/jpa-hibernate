package hieu.nv.jpa.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @EmbeddedId
    private ProductId id;

    @Version
    @Column(name = "version")
    private int version;

    @Column(name = "description")
    private String description;
}
