package com.flariz.sales.Domain.Entities;


import com.flariz.sales.Domain.Constant.Collections;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = Collections.CATEGORY)
public class Category {

    @Id
    private String _id;

    private Integer id;

    private String name;

    private String status;
}
