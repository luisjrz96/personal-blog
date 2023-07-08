package com.luisjrz96.blog.api.admin.query.service.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseAdminQueryService<T, I> {

  T findById(I identifier);

  Page<T> getPages(Pageable pageable);
}
