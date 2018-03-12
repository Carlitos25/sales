package com.flariz.sales.Repository;

import com.flariz.sales.Domain.Entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findById(@Param("id") Integer id);
}
