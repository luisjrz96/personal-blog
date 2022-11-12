package com.luisjrz96.personalblog.core.api.data.repositories;

import com.luisjrz96.personalblog.core.api.data.models.Post;
import com.luisjrz96.personalblog.core.api.data.models.QPost;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ICrudRepository<Post, Integer, QPost> {

    @Override
    @Modifying
    @Query("DELETE FROM Post p WHERE p.id=:id")
    void deleteById(@Param("id") Integer id);


    @Override
    default void customize(QuerydslBindings bindings, QPost post) {
        bindings.bind(post.title).first(((path, value) -> path.contains(value)));
    }
}
