package com.luisjrz96.personalblog.core.api.controllers.impl;

import com.luisjrz96.personalblog.core.api.data.models.Category;
import com.luisjrz96.personalblog.core.api.services.impl.CategoryService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudControllerImpl<Category, Integer> {

    @Autowired
    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> findAll(@QuerydslPredicate(root = Category.class) Predicate predicate) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", super.crudService.findAll(predicate));
        return ResponseEntity.ok(response);
    }

}
