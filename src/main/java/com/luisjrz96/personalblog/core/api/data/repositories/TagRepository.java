package com.luisjrz96.personalblog.core.api.data.repositories;

import com.luisjrz96.personalblog.core.api.data.models.QTag;
import com.luisjrz96.personalblog.core.api.data.models.Tag;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends ICrudRepository<Tag, Integer, QTag> {

    @Override
    default void customize(QuerydslBindings bindings, QTag tag) {
        bindings.bind(tag.name).first(((path, value) -> path.eq(value)));
    }
}
