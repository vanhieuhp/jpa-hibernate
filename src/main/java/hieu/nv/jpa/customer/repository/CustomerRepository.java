package hieu.nv.jpa.customer.repository;

import hieu.nv.jpa.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}