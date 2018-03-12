package com.flariz.sales.Controllers;

import com.flariz.sales.Applications.CategoryApplication;
import com.flariz.sales.Domain.Entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/categories")
public class CategoryController {
    @Autowired
    private CategoryApplication categoryApplication;

    @PostMapping
    private Category save(@RequestBody Category category) throws Exception {
        return this.categoryApplication.save(category);
    }

    @GetMapping
    private List<Category> getAll() {
        return this.categoryApplication.getAll();
    }

    @GetMapping("{id}")
    private Category getById(@PathVariable Integer id) throws Exception {
        return this.categoryApplication.getById(id);
    }
}
