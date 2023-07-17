package com.luisjrz96.blog.api.data.request.dto.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.luisjrz96.blog.api.data.request.dto.CategoryRequestDto;
import com.luisjrz96.blog.data.persistence.model.Category;
import org.junit.jupiter.api.Test;

class CategoryDtoProcessorTest {

  private final CategoryDtoProcessor categoryDtoProcessor = new CategoryDtoProcessor();

  @Test
  void test_dtoToEntitySave_Success() {
    CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
    categoryRequestDto.setName("Java");
    var category = categoryDtoProcessor.dtoToEntitySave(categoryRequestDto);
    assertEquals("Java", category.getName());
  }

  @Test
  void test_dtoToEntityUpdate_Success() {
    CategoryRequestDto categoryRequestDto = new CategoryRequestDto();
    categoryRequestDto.setName("Java");

    Category toUpdate = Category.builder().categoryId(1L).name("Python").build();
    var category = categoryDtoProcessor.dtoToEntityUpdate(categoryRequestDto, toUpdate);
    assertEquals("Java", category.getName());
    assertEquals(1L, category.getCategoryId());
  }

}
