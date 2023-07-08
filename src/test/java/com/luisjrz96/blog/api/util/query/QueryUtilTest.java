package com.luisjrz96.blog.api.util.query;

import static com.luisjrz96.blog.api.util.query.QueryUtil.getTypeClassName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.luisjrz96.blog.api.admin.query.service.AdminCategoryQueryService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

class QueryUtilTest {

  @Test
  void test_FailingWhenTryingToInstantiate_QueryUtil() {
    InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
      Class<?> clazz = QueryUtil.class;
      Constructor<?> constructor = clazz.getDeclaredConstructor();
      constructor.setAccessible(true);
      constructor.newInstance();
    });
    assertTrue((exception.getTargetException().getMessage().contains("Invalid instantiation")));
  }

  @Test
  void test_processMultiplePostRequest_WithAllInfo() {
    Pageable pageable = QueryUtil.processMultiplePostRequest(2, 10, "DESC");
    assertNotNull(pageable);
    assertEquals(2, pageable.getPageNumber());
    assertEquals(10, pageable.getPageSize());
    assertEquals(20, pageable.getOffset());
  }

  @Test
  void test_processMultiplePostRequest_WhenNullInput() {
    Pageable pageable = QueryUtil.processMultiplePostRequest(null, null, null);
    assertNotNull(pageable);
    assertEquals(0, pageable.getPageNumber());
    assertEquals(1, pageable.getPageSize());
    assertEquals(0, pageable.getOffset());
  }

  @Test
  void test_getTypeClassName_Success() {
    AdminCategoryQueryService adminCategoryQueryService = new AdminCategoryQueryService(null);
    var className = getTypeClassName(adminCategoryQueryService.getClass(), 0);
    assertNotNull(className);
    assertTrue(className.contains("Category"));
  }
}
