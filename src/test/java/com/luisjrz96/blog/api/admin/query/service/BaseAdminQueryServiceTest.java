package com.luisjrz96.blog.api.admin.query.service;

import static com.luisjrz96.blog.api.exception.NotFoundException.NOT_FOUND_MESSAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.luisjrz96.blog.api.data.response.dto.RestPage;
import com.luisjrz96.blog.api.exception.NotFoundException;
import com.luisjrz96.blog.data.persistence.model.Category;
import com.luisjrz96.blog.data.persistence.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class BaseAdminQueryServiceTest {

  @InjectMocks
  private  AdminCategoryQueryService baseAdminQueryService;

  @Mock
  private CategoryRepository repository;

  @Test
  void test_findById_Success() {
    when(repository.findById(1L)).thenReturn(Optional
        .of(Category.builder().categoryId(1L).name("Java").build()));
    var category = baseAdminQueryService.findById(1L);
    assertNotNull(category);
    assertEquals("Java", category.getName());
  }

  @Test
  void test_findById_Fail() {
    when(repository.findById(1L)).thenReturn(Optional.empty());
    var throwsData = assertThrows(NotFoundException.class, () -> {
      baseAdminQueryService.findById(1L);
    });
    assertNotNull(throwsData);
    assertEquals(throwsData.getMessage(), String.format(NOT_FOUND_MESSAGE,
        Category.class.getName(), "1"));
  }

  @Test
  void test_getPages_Success() {
    List<Category> categoryList =
        List.of(Category.builder().categoryId(1L).name("Development").build(),
            Category.builder().categoryId(2L).name("Testing").build(),
            Category.builder().categoryId(3L).name("DevOps").build());
    when(repository.findAll(Mockito.any(Pageable.class)))
        .thenReturn(new RestPage<>(new PageImpl<>(categoryList)));
    var categoryPage = baseAdminQueryService.getPages(Pageable.unpaged());
    assertNotNull(categoryPage);
    assertEquals(3, categoryPage.getContent().size());
    assertThat(categoryPage.getContent().stream().map(Category::getName).toList(),
        hasItems("Development", "Testing", "DevOps"));
  }
}
