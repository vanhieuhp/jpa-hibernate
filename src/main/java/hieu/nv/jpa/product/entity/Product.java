package hieu.nv.jpa.product.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "products")
@Data
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
