package com.flariz.sales.Applications;

import com.flariz.sales.Domain.Constant.Collections;
import com.flariz.sales.Domain.Entities.Customer;
import com.flariz.sales.Domain.Services.NextSequenceService;
import com.flariz.sales.Repository.CustomerRepository;
import com.flariz.sales.Service.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerApplication {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private NextSequenceService nextSequenceService;

    @Autowired
    private Asserts asserts;

    public Customer save(Customer customer) throws Exception {
        if (customer.getId() == null) {
            customer.setId(this.nextSequenceService.getNextId(Collections.CUSTOMER));
        }
        customer = this.customerRepository.save(customer);
        this.asserts.isNotNull(customer, "save error");
        return customer;
    }

    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    public Customer getById(Integer id) throws Exception {
        this.asserts.isNotNull(id, "id can not be null.");

        Customer customer = this.customerRepository.findById(id);
        this.asserts.isNotNull(customer, "customer is null.");

        return customer;
    }
}
