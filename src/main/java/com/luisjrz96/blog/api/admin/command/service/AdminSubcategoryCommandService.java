package com.luisjrz96.blog.api.admin.command.service;

import com.luisjrz96.blog.api.admin.command.service.generic.AdminCommandServiceImpl;
import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryService;
import com.luisjrz96.blog.api.data.request.dto.SubcategoryRequestDto;
import com.luisjrz96.blog.api.data.request.dto.processor.generic.RequestDtoProcessor;
import com.luisjrz96.blog.data.persistence.model.Subcategory;
import com.luisjrz96.blog.data.persistence.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminSubcategoryCommandService extends AdminCommandServiceImpl<SubcategoryRequestDto,
    Long, Subcategory> {
  public AdminSubcategoryCommandService(
      BaseAdminQueryService<Subcategory, Long> queryService,
      GenericRepository<Subcategory, Long> repository,
      RequestDtoProcessor<SubcategoryRequestDto, Subcategory> requestDtoProcessor) {
    super(queryService, repository, requestDtoProcessor);
  }
}
