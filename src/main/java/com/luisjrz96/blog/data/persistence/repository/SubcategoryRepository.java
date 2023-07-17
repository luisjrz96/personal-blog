package com.luisjrz96.blog.data.persistence.repository;

import com.luisjrz96.blog.data.persistence.model.Subcategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubcategoryRepository extends GenericRepository<Subcategory, Long> {
  Page<Subcategory> findByCategoryName(Pageable pageable, String categoryName);
}
