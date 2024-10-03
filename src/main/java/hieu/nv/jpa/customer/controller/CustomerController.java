package hieu.nv.jpa.customer.controller;

import hieu.nv.jpa.customer.entity.Customer;
import hieu.nv.jpa.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
