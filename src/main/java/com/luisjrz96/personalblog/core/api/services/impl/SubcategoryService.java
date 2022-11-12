package com.luisjrz96.personalblog.core.api.services.impl;

import com.luisjrz96.personalblog.core.api.data.models.QSubcategory;
import com.luisjrz96.personalblog.core.api.data.models.Subcategory;
import com.luisjrz96.personalblog.core.api.data.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("subcategoryService")
public class SubcategoryService extends CrudServiceImpl<SubcategoryRepository, Subcategory, Integer, QSubcategory>{

    @Autowired
    public SubcategoryService(SubcategoryRepository repository) {
        super(repository);
    }
}
