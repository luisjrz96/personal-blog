package com.luisjrz96.blog.api.admin.query.service;

import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryServiceImpl;
import com.luisjrz96.blog.data.database.model.Tag;
import com.luisjrz96.blog.data.database.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminTagQueryService extends BaseAdminQueryServiceImpl<Tag, Long> {

  public AdminTagQueryService(GenericRepository<Tag, Long> repository) {
    super(repository);
  }
}
