package com.luisjrz96.blog.api.admin.command.service;

import com.luisjrz96.blog.api.admin.command.service.generic.AdminCommandServiceImpl;
import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryService;
import com.luisjrz96.blog.api.data.request.dto.CategoryRequestDto;
import com.luisjrz96.blog.api.data.request.dto.processor.generic.RequestDtoProcessor;
import com.luisjrz96.blog.data.database.model.Category;
import com.luisjrz96.blog.data.database.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminCategoryCommandService extends AdminCommandServiceImpl<CategoryRequestDto, Long,
    Category>{

  public AdminCategoryCommandService(BaseAdminQueryService<Category, Long> queryService,
      GenericRepository<Category, Long> repository,
      RequestDtoProcessor<CategoryRequestDto, Category> requestDtoProcessor) {
    super(queryService, repository, requestDtoProcessor);
  }
}
