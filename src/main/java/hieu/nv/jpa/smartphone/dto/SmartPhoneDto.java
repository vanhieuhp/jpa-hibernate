package hieu.nv.jpa.smartphone.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SmartPhoneDto {

	private String id;
	private String color;
	private BigDecimal price;
	private String model;
	private String size;

}
