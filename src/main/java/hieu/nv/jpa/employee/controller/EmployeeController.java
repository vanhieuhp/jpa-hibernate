package hieu.nv.jpa.employee.controller;

import hieu.nv.jpa.employee.dto.EmployeeDto;
import hieu.nv.jpa.employee.entity.Employee;
import hieu.nv.jpa.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employee) {
		return ResponseEntity.ok(employeeService.createEmployee(employee));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@GetMapping
	public ResponseEntity<Iterable<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
}
