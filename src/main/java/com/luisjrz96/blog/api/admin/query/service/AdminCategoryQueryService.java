package com.luisjrz96.blog.api.admin.query.service;

import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryServiceImpl;
import com.luisjrz96.blog.data.database.model.Category;
import com.luisjrz96.blog.data.database.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminCategoryQueryService extends BaseAdminQueryServiceImpl<Category, Long> {

  public AdminCategoryQueryService(GenericRepository<Category, Long> repository) {
    super(repository);
  }
}
