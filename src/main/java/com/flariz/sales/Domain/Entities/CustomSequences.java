package com.flariz.sales.Domain.Entities;

import com.flariz.sales.Domain.Constant.Collections;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = Collections.SEQUENCE)
public class CustomSequences {
    @Id
    private String id;
    private Integer seq;
}