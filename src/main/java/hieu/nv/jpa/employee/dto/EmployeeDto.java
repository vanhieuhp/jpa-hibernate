package hieu.nv.jpa.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link hieu.nv.jpa.employee.entity.Employee}
 */
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto implements Serializable {
	private String id;
	private String name;
	private double salary;
}