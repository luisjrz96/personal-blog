package com.luisjrz96.personalblog.core.api.data.repositories;
import com.luisjrz96.personalblog.core.api.data.models.QSubcategory;
import com.luisjrz96.personalblog.core.api.data.models.Subcategory;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends ICrudRepository<Subcategory, Integer, QSubcategory> {

    @Override
    default void customize(QuerydslBindings bindings, QSubcategory subcategory) {
        bindings.bind(subcategory.name).first(((path, value) -> path.eq(value)));
    }
}
