package com.flariz.sales.Domain.Entities;

import com.flariz.sales.Domain.Constant.Collections;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = Collections.CUSTOMER)
public class Customer {

    @Id
    private String _id;

    private Integer id;

    private String firstName;

    private String lastName;

    private String status;
}
