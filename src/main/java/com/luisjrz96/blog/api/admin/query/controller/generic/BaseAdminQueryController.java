package com.luisjrz96.blog.api.admin.query.controller.generic;

import com.luisjrz96.blog.api.data.response.dto.RestPage;

public interface BaseAdminQueryController<T, I> {

  T findById(I identifier);

  RestPage<T> getPages(Integer pageNumber, Integer pageSize, String sortDirection);
}
