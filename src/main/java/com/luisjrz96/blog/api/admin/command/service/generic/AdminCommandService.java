package com.luisjrz96.blog.api.admin.command.service.generic;

public interface AdminCommandService<D, I> {

  void save(D dto);

  void update(D dto, I identifier);

  void delete(I identifier);
}
