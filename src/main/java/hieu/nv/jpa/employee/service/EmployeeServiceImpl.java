package hieu.nv.jpa.employee.service;

import hieu.nv.jpa.employee.dto.EmployeeDto;
import hieu.nv.jpa.employee.entity.Employee;
import hieu.nv.jpa.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(EmployeeDto employee) {
		Employee newEmployee = new Employee();
		newEmployee.setName(employee.getName());
		newEmployee.setSalary(employee.getSalary());
		return employeeRepository.save(newEmployee);
	}

	@Override
	public Employee getEmployeeById(String id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Iterable<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
