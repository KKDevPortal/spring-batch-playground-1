package com.kkdevportal.spring_batch_playground_1.repository;

import com.kkdevportal.spring_batch_playground_1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
