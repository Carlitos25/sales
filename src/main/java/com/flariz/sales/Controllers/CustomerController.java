package com.flariz.sales.Controllers;

import com.flariz.sales.Applications.CustomerApplication;
import com.flariz.sales.Domain.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/customers")
public class CustomerController {
    @Autowired
    private CustomerApplication customerApplication;

    @PostMapping
    private Customer save(@RequestBody Customer customer) throws Exception {
        return this.customerApplication.save(customer);
    }

    @GetMapping
    private List<Customer> getAll() {
        return this.customerApplication.getAll();
    }

    @GetMapping("{id}")
    private Customer getById(@PathVariable Integer id) throws Exception {
        return this.customerApplication.getById(id);
    }
}
