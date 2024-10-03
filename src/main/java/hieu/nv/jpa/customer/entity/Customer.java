package hieu.nv.jpa.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;

    @Column(name = "age")
    private int age;
}
