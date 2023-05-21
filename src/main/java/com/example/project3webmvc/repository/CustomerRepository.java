package com.example.project3webmvc.repository;

import com.example.project3webmvc.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerIDAndPassword(int customerID, String password);
}
