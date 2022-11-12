package com.luisjrz96.personalblog.core.api.data.repositories;

import com.luisjrz96.personalblog.core.api.data.models.Comment;
import com.luisjrz96.personalblog.core.api.data.models.QComment;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends ICrudRepository<Comment, Integer, QComment> {

    @Override
    default void customize(QuerydslBindings bindings, QComment comment) {
        bindings.bind(comment.id).first(((path, value) -> path.eq(value)));
    }
}
