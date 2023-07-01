package com.luisjrz96.blog.data.repository;

import com.luisjrz96.blog.data.model.Subcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubcategoryRepository extends PagingAndSortingRepository<Subcategory, Long> {
  Page<Subcategory> findByCategoryName(Pageable pageable, String categoryName);
}
