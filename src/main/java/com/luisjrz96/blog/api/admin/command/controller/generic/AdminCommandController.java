package com.luisjrz96.blog.api.admin.command.controller.generic;


public interface AdminCommandController<D, I> {

  void delete(I identifier);

  void save(D entityDto);

  void update(D entityDto, I identifier);

}
