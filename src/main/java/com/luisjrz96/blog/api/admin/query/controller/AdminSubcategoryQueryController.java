package com.luisjrz96.blog.api.admin.query.controller;

import static com.luisjrz96.blog.util.Constants.ADMIN_SUBCATEGORIES_PATH;

import com.luisjrz96.blog.api.admin.query.controller.generic.BaseAdminQueryControllerImpl;
import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryService;
import com.luisjrz96.blog.data.persistence.model.Subcategory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ADMIN_SUBCATEGORIES_PATH)
@RestController
public class AdminSubcategoryQueryController extends BaseAdminQueryControllerImpl<Subcategory,
    Long> {
  public AdminSubcategoryQueryController(BaseAdminQueryService<Subcategory, Long> queryService) {
    super(queryService);
  }
}
