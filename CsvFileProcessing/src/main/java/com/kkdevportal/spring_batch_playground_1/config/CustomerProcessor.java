package com.kkdevportal.spring_batch_playground_1.config;


import com.kkdevportal.spring_batch_playground_1.entity.Customer;
import jakarta.annotation.Nonnull;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        return customer;
    }
}
