package com.kkdevportal.spring_batch_playground_1.processor;

import com.kkdevportal.spring_batch_playground_1.model.Customer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {

        customer.setName(customer.getName().toUpperCase());

        return customer;
    }
}
