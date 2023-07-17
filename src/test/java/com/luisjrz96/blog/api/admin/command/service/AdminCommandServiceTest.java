package com.luisjrz96.blog.api.admin.command.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.luisjrz96.blog.api.admin.query.service.AdminCategoryQueryService;
import com.luisjrz96.blog.api.data.request.dto.CategoryRequestDto;
import com.luisjrz96.blog.api.data.request.dto.processor.CategoryDtoProcessor;
import com.luisjrz96.blog.data.persistence.model.Category;
import com.luisjrz96.blog.data.persistence.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AdminCommandServiceTest {

  @InjectMocks
  private AdminCategoryCommandService categoryCommandService;

  @Mock
  private AdminCategoryQueryService categoryQueryService;

  @Mock
  private CategoryRepository categoryRepository;

  @Mock
  private CategoryDtoProcessor categoryDtoProcessor;

  @Test
  void test_delete_Success() {
    when(categoryQueryService.findById(1L)).thenReturn(Category.builder()
        .categoryId(1L).name("foo").build());
    doNothing().when(categoryRepository).delete(any(Category.class));
    categoryCommandService.delete(1L);

    var categoryCaptor = ArgumentCaptor.forClass(Category.class);
    verify(categoryQueryService, times(1)).findById(1L);
    verify(categoryRepository, times(1)).delete(categoryCaptor.capture());
    assertEquals("foo", categoryCaptor.getValue().getName());
    assertEquals(1L, categoryCaptor.getValue().getCategoryId());

  }

  @Test
  void test_save_Success() {
    CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
    categoryRequestDto.setName("Java");

    when(categoryDtoProcessor.dtoToEntitySave(categoryRequestDto))
        .thenReturn(Category.builder().name(categoryRequestDto.getName()).build());
    doNothing().when(categoryRepository).save(any(Category.class));
    categoryCommandService.save(categoryRequestDto);

    var categoryCaptor = ArgumentCaptor.forClass(Category.class);
    verify(categoryRepository, times(1)).save(categoryCaptor.capture());
    assertEquals("Java", categoryCaptor.getValue().getName());
  }

  @Test
  void test_update_Success() {
    CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
    categoryRequestDto.setName("Python");
    Category category = Category.builder().categoryId(1L).name("Java").build();

    when(categoryQueryService.findById(1L)).thenReturn(category);
    when(categoryDtoProcessor.dtoToEntityUpdate(categoryRequestDto, category))
        .thenReturn(Category.builder().name(categoryRequestDto.getName()).build());
    doNothing().when(categoryRepository).save(any(Category.class));
    categoryCommandService.update(categoryRequestDto, 1L);

    var categoryCaptor = ArgumentCaptor.forClass(Category.class);
    verify(categoryQueryService, times(1)).findById(1L);
    verify(categoryRepository, times(1)).save(categoryCaptor.capture());
    assertEquals("Python", categoryCaptor.getValue().getName());
  }
}
