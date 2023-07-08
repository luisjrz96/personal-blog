package com.luisjrz96.blog.api.admin.query.controller.generic;

import static com.luisjrz96.blog.util.Constants.PAGE_NUMBER;
import static com.luisjrz96.blog.util.Constants.PAGE_SIZE;
import static com.luisjrz96.blog.util.Constants.SORT_DIRECTION;

import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryService;
import com.luisjrz96.blog.api.data.response.dto.RestPage;
import com.luisjrz96.blog.api.util.query.QueryUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
public class BaseAdminQueryControllerImpl<T, I> implements BaseAdminQueryController<T, I> {

  private final BaseAdminQueryService<T, I> queryService;

  @GetMapping("/{id}")
  @Override
  public T findById(@PathVariable(name = "id") I identifier) {
    return queryService.findById(identifier);
  }

  @GetMapping
  @Override
  public RestPage<T> getPages(
      @RequestParam(name = PAGE_NUMBER, required = false) Integer pageNumber,
      @RequestParam(name = PAGE_SIZE, required = false) Integer pageSize,
      @RequestParam(name = SORT_DIRECTION, required = false) String sortDirection) {
    return new RestPage<>(queryService.getPages(QueryUtil.processMultiplePostRequest(pageNumber,
        pageSize, sortDirection)));
  }
}
