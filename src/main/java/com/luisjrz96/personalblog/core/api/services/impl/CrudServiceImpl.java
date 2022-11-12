package com.luisjrz96.personalblog.core.api.services.impl;

import com.luisjrz96.personalblog.core.Utils;
import com.luisjrz96.personalblog.core.api.data.repositories.ICrudRepository;
import com.luisjrz96.personalblog.core.api.exceptions.InternalServerServiceException;
import com.luisjrz96.personalblog.core.api.exceptions.NotFoundException;
import com.luisjrz96.personalblog.core.api.data.models.BaseModel;
import com.luisjrz96.personalblog.core.api.services.ICrudService;
import com.querydsl.core.types.EntityPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;

import com.querydsl.core.types.Predicate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Slf4j
public class CrudServiceImpl<T extends ICrudRepository<V, ID, QV>, V extends BaseModel, ID, QV extends EntityPath<?>> implements ICrudService<V, ID> {
    protected final T repository;
    public CrudServiceImpl(T repository) {
        this.repository = repository;
    }

    @Override
    public List<V> findAll() {
        List<V> result = null;
        try {
            result = (List<V>) repository.findAll();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new InternalServerServiceException(ex);
        }
        return result;
    }

    @Override
    public V save(V entity) {
        V object = null;
        try {
            object = repository.save(entity);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new InternalServerServiceException(ex);
        }
        return object;
    }

    @Override
    public V update(V entity, ID id) {
        V object = null;
        //do something here to update fields
        try {
            object = repository.save(entity);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new InternalServerServiceException(ex);
        }
        return object;
    }

    @Override
    public V findById(ID id) {
        V object = null;
        try {
            object = repository.findById(id)
                    .orElseThrow(() ->  new NotFoundException(Utils.getGenericTypeName(((ParameterizedType) getClass().getGenericSuperclass()), 1), String.valueOf(id)));
        } catch (EmptyResultDataAccessException | NotFoundException ex) {
            log.error(ex.getMessage());
            throw new NotFoundException(ex.getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new InternalServerServiceException(ex);
        }

        return object;
    }

    @Override
    public void delete(ID id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            log.error(ex.getMessage());
            throw new NotFoundException(Utils.getGenericTypeName(((ParameterizedType) getClass().getGenericSuperclass()), 1), String.valueOf(id));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new InternalServerServiceException(ex);
        }
    }

    @Override
    public List<V> findAll(Predicate predicate) {
        List<V> result = null;
        try {
            result = (List<V>) repository.findAll(predicate);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new InternalServerServiceException(ex);
        }
        return result;
    }

}
