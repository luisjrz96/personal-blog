package com.luisjrz96.blog.api.admin.command.controller;

import static com.luisjrz96.blog.util.Constants.ADMIN_CATEGORIES_PATH;

import com.luisjrz96.blog.api.admin.command.controller.generic.AdminCommandControllerImpl;
import com.luisjrz96.blog.api.admin.command.service.generic.AdminCommandService;
import com.luisjrz96.blog.api.data.request.dto.CategoryRequestDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ADMIN_CATEGORIES_PATH)
@RestController
public class AdminCategoryCommandController extends AdminCommandControllerImpl<CategoryRequestDto,
    Long> {

  public AdminCategoryCommandController(
      AdminCommandService<CategoryRequestDto, Long> commandService) {
    super(commandService);
  }
}
