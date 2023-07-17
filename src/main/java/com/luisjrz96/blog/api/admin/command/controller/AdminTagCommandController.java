package com.luisjrz96.blog.api.admin.command.controller;

import static com.luisjrz96.blog.util.Constants.ADMIN_TAGS_PATH;

import com.luisjrz96.blog.api.admin.command.controller.generic.AdminCommandControllerImpl;
import com.luisjrz96.blog.api.admin.command.service.generic.AdminCommandService;
import com.luisjrz96.blog.api.data.request.dto.TagRequestDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ADMIN_TAGS_PATH)
@RestController
public class AdminTagCommandController extends AdminCommandControllerImpl<TagRequestDto, Long> {
  public AdminTagCommandController(
      AdminCommandService<TagRequestDto, Long> commandService) {
    super(commandService);
  }
}
