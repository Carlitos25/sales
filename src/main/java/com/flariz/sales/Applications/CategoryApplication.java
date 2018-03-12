package com.flariz.sales.Applications;

import com.flariz.sales.Domain.Constant.Collections;
import com.flariz.sales.Domain.Entities.Category;
import com.flariz.sales.Domain.Entities.Customer;
import com.flariz.sales.Domain.Services.NextSequenceService;
import com.flariz.sales.Repository.CategoryRepostory;
import com.flariz.sales.Service.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryApplication {

    @Autowired
    private CategoryRepostory categoryRepostory;

    @Autowired
    private Asserts asserts;

    @Autowired
    private NextSequenceService nextSequenceService;

    public Category save(Category category) throws Exception {

        if (category.getId() == null) {
            category.setId(this.nextSequenceService.getNextId(Collections.CATEGORY));
        }

        category = this.categoryRepostory.save(category);
        this.asserts.isNotNull(category, "save error");
        return category;
    }

    public List<Category> getAll() {
        return this.categoryRepostory.findAll();
    }

    public Category getById(Integer id) throws Exception {
        this.asserts.isNotNull(id, "id can not be null.");

        Category category = this.categoryRepostory.findById(id);
        this.asserts.isNotNull(category, "category is null.");
        return category;
    }
}
