package com.luisjrz96.personalblog.core.api.data.repositories;

import com.querydsl.core.types.EntityPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ICrudRepository<T, ID, V extends EntityPath<?>> extends CrudRepository<T, ID>,
        QuerydslPredicateExecutor<T>,
        QuerydslBinderCustomizer<V> {
}
