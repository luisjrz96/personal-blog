package com.luisjrz96.personalblog.core.api.services.impl;

import com.luisjrz96.personalblog.core.api.data.models.Category;
import com.luisjrz96.personalblog.core.api.data.models.QCategory;
import com.luisjrz96.personalblog.core.api.data.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("categoryService")
public class CategoryService extends CrudServiceImpl<CategoryRepository, Category, Integer, QCategory> {

    @Autowired
    public CategoryService(CategoryRepository repository) {
        super(repository);
    }

}
