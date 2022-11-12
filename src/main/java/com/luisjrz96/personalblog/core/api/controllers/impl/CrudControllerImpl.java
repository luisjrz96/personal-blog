package com.luisjrz96.personalblog.core.api.controllers.impl;

import com.luisjrz96.personalblog.core.api.controllers.ICrudController;
import com.luisjrz96.personalblog.core.api.data.models.BaseModel;
import com.luisjrz96.personalblog.core.api.services.ICrudService;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@EnableSpringDataWebSupport
public class CrudControllerImpl<T extends BaseModel, ID> implements ICrudController<T, ID> {

    protected   ICrudService<T, ID> crudService;
    public CrudControllerImpl(ICrudService<T, ID> crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    @Override
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("response", crudService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Map<String, Object>> findById(@PathVariable(name = "id") ID id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", crudService.findById(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping
    @Override
    public ResponseEntity<Map<String, Object>> save(T object) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", crudService.save(object));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(T object, ID id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", crudService.update(object, id));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Map<String, Object>> delete(@PathVariable(name = "id") ID id) {
        Map<String, Object> response = new HashMap<>();
        crudService.delete(id);
        response.put("response", "deleted");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
