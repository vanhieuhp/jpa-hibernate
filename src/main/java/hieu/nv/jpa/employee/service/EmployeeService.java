package hieu.nv.jpa.employee.service;

import hieu.nv.jpa.employee.dto.EmployeeDto;
import hieu.nv.jpa.employee.entity.Employee;

public interface EmployeeService {
	Employee createEmployee(EmployeeDto employee);

	Employee getEmployeeById(String id);

	Iterable<Employee> getAllEmployees();
}
