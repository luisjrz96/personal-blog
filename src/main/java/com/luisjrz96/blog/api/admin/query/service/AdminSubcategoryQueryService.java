package com.luisjrz96.blog.api.admin.query.service;

import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryServiceImpl;
import com.luisjrz96.blog.data.persistence.model.Subcategory;
import com.luisjrz96.blog.data.persistence.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminSubcategoryQueryService extends BaseAdminQueryServiceImpl<Subcategory, Long> {
  public AdminSubcategoryQueryService(GenericRepository<Subcategory, Long> repository) {
    super(repository);
  }
}
