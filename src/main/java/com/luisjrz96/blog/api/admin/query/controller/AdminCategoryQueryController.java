package com.luisjrz96.blog.api.admin.query.controller;

import static com.luisjrz96.blog.util.Constants.ADMIN_CATEGORIES_PATH;

import com.luisjrz96.blog.api.admin.query.controller.generic.BaseAdminQueryControllerImpl;
import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryService;
import com.luisjrz96.blog.data.persistence.model.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ADMIN_CATEGORIES_PATH)
@RestController
public class AdminCategoryQueryController extends BaseAdminQueryControllerImpl<Category, Long> {

  public AdminCategoryQueryController(
      BaseAdminQueryService<Category, Long> queryService) {
    super(queryService);
  }
}
