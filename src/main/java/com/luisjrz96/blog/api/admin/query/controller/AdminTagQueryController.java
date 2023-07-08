package com.luisjrz96.blog.api.admin.query.controller;

import static com.luisjrz96.blog.util.Constants.ADMIN_TAGS_PATH;

import com.luisjrz96.blog.api.admin.query.controller.generic.BaseAdminQueryControllerImpl;
import com.luisjrz96.blog.api.admin.query.service.generic.BaseAdminQueryService;
import com.luisjrz96.blog.data.database.model.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ADMIN_TAGS_PATH)
@RestController
public class AdminTagQueryController extends BaseAdminQueryControllerImpl<Tag, Long> {

  public AdminTagQueryController(BaseAdminQueryService<Tag, Long> queryService) {
    super(queryService);
  }
}
