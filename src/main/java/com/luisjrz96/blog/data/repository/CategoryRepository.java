package com.luisjrz96.blog.data.repository;

import com.luisjrz96.blog.data.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
