package com.luisjrz96.blog.data.persistence.repository;

import com.luisjrz96.blog.data.persistence.model.Category;
import java.util.Optional;

public interface CategoryRepository extends GenericRepository<Category, Long> {
  Optional<Category> findByName(String name);
}
