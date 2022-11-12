package com.luisjrz96.personalblog.core.api.controllers;

import com.luisjrz96.personalblog.core.api.data.models.BaseModel;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ICrudController<T extends BaseModel, ID> {

    public ResponseEntity<Map<String, Object>> findAll();

    public ResponseEntity<Map<String, Object>> findById(ID id);

    public ResponseEntity<Map<String, Object>> save(T object);

    public ResponseEntity<Map<String, Object>> update(T object, ID id);

    public ResponseEntity<Map<String, Object>> delete(ID id);
}
