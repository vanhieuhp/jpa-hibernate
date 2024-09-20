package hieu.nv.jpa.employee.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

	@Id
	@UuidGenerator
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "salary")
	private double salary;

	@Access(AccessType.PROPERTY)
	@Column(name = "salary")
	public double getSalary() {
		// Logging retrieval logic
		System.out.println("Salary retrieved: " + this.salary);
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
		// Logging addition logic
		System.out.println("Salary updated: " + salary);
	}
}
