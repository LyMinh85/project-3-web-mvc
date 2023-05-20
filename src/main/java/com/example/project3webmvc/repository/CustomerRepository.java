package com.example.project3webmvc.repository;

import com.example.project3webmvc.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
