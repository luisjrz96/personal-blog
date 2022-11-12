package com.luisjrz96.personalblog.core.api.controllers.impl;

import com.luisjrz96.personalblog.core.api.data.models.Subcategory;
import com.luisjrz96.personalblog.core.api.services.impl.SubcategoryService;
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
@RequestMapping("/subcategories")
public class SubcategoryController extends CrudControllerImpl<Subcategory, Integer> {

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        super(subcategoryService);
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> findAll(@QuerydslPredicate(root = Subcategory.class) Predicate predicate) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", super.crudService.findAll(predicate));
        return ResponseEntity.ok(response);
    }
}
