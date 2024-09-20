package hieu.nv.jpa.employee.repository;

import hieu.nv.jpa.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}