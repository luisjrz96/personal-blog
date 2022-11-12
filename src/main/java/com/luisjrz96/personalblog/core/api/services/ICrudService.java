package com.luisjrz96.personalblog.core.api.services;


import com.luisjrz96.personalblog.core.api.data.models.BaseModel;

import com.querydsl.core.types.Predicate;
import java.util.List;

public interface ICrudService <T extends BaseModel, ID> {
    public List<T> findAll();
    public T save(T entity);
    public T update(T entity, ID id);
    public T findById(ID id);
    public void delete(ID id);
    List<T> findAll(Predicate predicate);
}
