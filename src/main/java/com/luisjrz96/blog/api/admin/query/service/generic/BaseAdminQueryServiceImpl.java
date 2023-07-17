package com.luisjrz96.blog.api.admin.query.service.generic;

import static com.luisjrz96.blog.api.util.query.QueryUtil.getTypeClassName;

import com.luisjrz96.blog.api.exception.NotFoundException;
import com.luisjrz96.blog.data.persistence.repository.GenericRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class BaseAdminQueryServiceImpl<T, I> implements BaseAdminQueryService<T, I> {

  private final GenericRepository<T, I> repository;

  @Override
  public T findById(I identifier) {
    return repository.findById(identifier)
        .orElseThrow(() -> new NotFoundException(getTypeClassName(getClass(), 0),
            String.valueOf(identifier)));
  }

  @Override
  public Page<T> getPages(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
