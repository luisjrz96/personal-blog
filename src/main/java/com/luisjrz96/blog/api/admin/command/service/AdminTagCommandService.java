package com.luisjrz96.blog.api.admin.command.service;

import com.luisjrz96.blog.api.admin.command.service.generic.AdminCommandServiceImpl;
import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryService;
import com.luisjrz96.blog.api.data.request.dto.TagRequestDto;

import com.luisjrz96.blog.api.data.request.dto.processor.generic.RequestDtoProcessor;
import com.luisjrz96.blog.data.database.model.Tag;
import com.luisjrz96.blog.data.database.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminTagCommandService extends AdminCommandServiceImpl<TagRequestDto, Long, Tag> {

  public AdminTagCommandService(
      BaseAdminQueryService<Tag, Long> queryService,
      GenericRepository<Tag, Long> repository,
      RequestDtoProcessor<TagRequestDto, Tag> requestDtoProcessor) {
    super(queryService, repository, requestDtoProcessor);
  }
}
