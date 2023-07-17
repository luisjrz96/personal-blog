package com.luisjrz96.blog.api.admin.command.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.luisjrz96.blog.api.admin.command.service.AdminCategoryCommandService;
import com.luisjrz96.blog.api.data.request.dto.CategoryRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AdminCommandControllerTest {

  @InjectMocks
  private AdminCategoryCommandController adminCategoryCommandController;

  @Mock
  private AdminCategoryCommandService categoryCommandService;


  @Test
  void test_delete_Success() {
    doNothing().when(categoryCommandService).delete(anyLong());
    adminCategoryCommandController.delete(1L);
    verify(categoryCommandService, times(1)).delete(anyLong());
  }

  @Test
  void test_save_Success() {
    CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
    categoryRequestDto.setName("Java");
    doNothing().when(categoryCommandService).save(any(CategoryRequestDto.class));
    adminCategoryCommandController.save(categoryRequestDto);
    verify(categoryCommandService, times(1)).save(any(CategoryRequestDto.class));
  }

  @Test
  void test_update_Success() {
    CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
    categoryRequestDto.setName("Java");
    doNothing().when(categoryCommandService).update(any(CategoryRequestDto.class), anyLong());
    adminCategoryCommandController.update(categoryRequestDto, 1L);
    verify(categoryCommandService, times(1)).update(any(CategoryRequestDto.class), anyLong());
  }
}
