package com.kkdevportal.spring_batch_playground_1.repository;

import com.kkdevportal.spring_batch_playground_1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
