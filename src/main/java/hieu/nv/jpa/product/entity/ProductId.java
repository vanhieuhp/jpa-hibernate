package hieu.nv.jpa.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Embeddable
public class ProductId implements Serializable {

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private BigDecimal price;

	public ProductId(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public ProductId() {

	}
}
