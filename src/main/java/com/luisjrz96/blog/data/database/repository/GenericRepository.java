package com.luisjrz96.blog.data.database.repository;

import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface GenericRepository<T, I> extends PagingAndSortingRepository<T, I> {
  Optional<T> findById(I identifier);
  void delete(T entity);
  void save(T entity);

}
