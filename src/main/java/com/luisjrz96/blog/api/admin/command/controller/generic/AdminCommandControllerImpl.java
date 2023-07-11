package com.luisjrz96.blog.api.admin.command.controller.generic;

import com.luisjrz96.blog.api.admin.command.service.generic.AdminCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public class AdminCommandControllerImpl<D, I> implements AdminCommandController<D,I> {

  private final AdminCommandService<D, I> commandService;

  @DeleteMapping("/{id}")
  @Override
  public void delete(@PathVariable(name = "id") I identifier) {
    commandService.delete(identifier);
  }

  @PostMapping
  @Override
  public void save(@RequestBody D entityDto) {
    commandService.save(entityDto);
  }

  @PutMapping("/{id}")
  @Override
  public void update(@RequestBody D entityDto, @PathVariable(name = "id") I identifier) {
    commandService.update(entityDto, identifier);
  }
}
