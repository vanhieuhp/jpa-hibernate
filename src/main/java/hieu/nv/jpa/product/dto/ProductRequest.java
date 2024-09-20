package hieu.nv.jpa.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    private String name;
    private BigDecimal price;
    private String description;

}
