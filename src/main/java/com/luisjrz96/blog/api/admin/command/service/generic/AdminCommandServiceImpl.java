package com.luisjrz96.blog.api.admin.command.service.generic;

import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryService;
import com.luisjrz96.blog.api.data.request.dto.processor.generic.RequestDtoProcessor;
import com.luisjrz96.blog.data.persistence.repository.GenericRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class AdminCommandServiceImpl<D, I, E> implements AdminCommandService<D, I> {

  private final BaseAdminQueryService<E, I> queryService;
  private final GenericRepository<E, I> repository;
  private final RequestDtoProcessor<D, E> requestDtoProcessor;

  @Override
  public void save(D dto) {
    repository.save(requestDtoProcessor.dtoToEntitySave(dto));
  }

  @Override
  public void update(D dto, I identifier) {
    var toUpdate = queryService.findById(identifier);
    repository.save(requestDtoProcessor.dtoToEntityUpdate(dto, toUpdate));
  }

  @Override
  public void delete(I identifier) {
    repository.delete(queryService.findById(identifier));
  }
}
