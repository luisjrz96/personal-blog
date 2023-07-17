package com.luisjrz96.blog.api.admin.command.controller;

import static com.luisjrz96.blog.util.Constants.ADMIN_SUBCATEGORIES_PATH;

import com.luisjrz96.blog.api.admin.command.controller.generic.AdminCommandControllerImpl;
import com.luisjrz96.blog.api.admin.command.service.generic.AdminCommandService;
import com.luisjrz96.blog.api.data.request.dto.SubcategoryRequestDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ADMIN_SUBCATEGORIES_PATH)
@RestController
public class AdminSubcategoryCommandController extends
    AdminCommandControllerImpl<SubcategoryRequestDto, Long> {
  public AdminSubcategoryCommandController(
      AdminCommandService<SubcategoryRequestDto, Long> commandService) {
    super(commandService);
  }
}
