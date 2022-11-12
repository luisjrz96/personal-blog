package com.luisjrz96.personalblog.core.api.data.repositories;

import com.luisjrz96.personalblog.core.api.data.models.Category;
import com.luisjrz96.personalblog.core.api.data.models.QCategory;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ICrudRepository<Category, Integer, QCategory>  {
    @Override
    default void customize(QuerydslBindings bindings, QCategory category) {
        bindings.bind(category.name).first(((path, value) -> path.eq(value)));
    }
}
