package com.luisjrz96.blog.data.repository;

import com.luisjrz96.blog.data.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
}
