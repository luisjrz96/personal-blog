package com.luisjrz96.blog.data.repository;

import com.luisjrz96.blog.data.model.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
}
