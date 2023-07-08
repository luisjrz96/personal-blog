package com.luisjrz96.blog.api.admin.query.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.luisjrz96.blog.api.admin.query.service.AdminCategoryQueryService;
import com.luisjrz96.blog.api.data.response.dto.RestPage;
import com.luisjrz96.blog.data.database.model.Category;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
public class BaseAdminQueryControllerTest {

  @InjectMocks
  private AdminCategoryQueryController adminCategoryQueryController;

  @Mock
  private AdminCategoryQueryService adminCategoryQueryService;

  @Test
  void test_findById_Success() {
    when(adminCategoryQueryService.findById(1L))
        .thenReturn(Category.builder().categoryId(1L).name("Development").build());

    var category = adminCategoryQueryController.findById(1L);
    assertNotNull(category);
    assertEquals(1L, category.getCategoryId());
    assertEquals("Development", category.getName());
  }

  @Test
  void test_getPages_Success() {
    List<Category> categoryList = List.of(Category.builder().categoryId(1L).name("Testing")
        .build(), Category.builder().categoryId(2L).name("Development").build(),
        Category.builder().categoryId(3L).name("DevOps").build());
    when(adminCategoryQueryService.getPages(Mockito.any(Pageable.class)))
        .thenReturn(new RestPage<>(new PageImpl<>(categoryList)));

    var categoryPages = adminCategoryQueryController.getPages(0, 100, "ASC");
    assertNotNull(categoryPages);
    assertEquals(3, categoryPages.getContent().size());
    assertThat(categoryPages.getContent().stream().map(Category::getName).toList(),
        hasItems("Development", "Testing", "DevOps"));
  }
}
