package com.flariz.sales.Repository;

import com.flariz.sales.Domain.Entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepostory extends MongoRepository<Category, String> {
    Category findById(@Param("id") Integer id);
}
