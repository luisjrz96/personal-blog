package com.luisjrz96.blog.util;

import static com.luisjrz96.blog.util.Constants.DEFAULT_PAGE_NUMBER;
import static com.luisjrz96.blog.util.Constants.DEFAULT_PAGE_SIZE;
import static com.luisjrz96.blog.util.Util.getDefaultDirection;
import static com.luisjrz96.blog.util.Util.getDefaultPageNumber;
import static com.luisjrz96.blog.util.Util.getDefaultPageSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

class UtilTest {

  @Test
  void test_FailingWhenTryingToInstantiate_Utils() {
    InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
      Class<?> clazz = Util.class;
      Constructor<?> constructor = clazz.getDeclaredConstructor();
      constructor.setAccessible(true);
      constructor.newInstance();
    });
    assertTrue((exception.getTargetException().getMessage().contains("Invalid instantiation")));
  }

  @Test
  void test_getDefaultDirection_WhenValidSortDirection() {
    var direction = getDefaultDirection("DESC");
    assertNotNull(direction);
    assertEquals(Sort.Direction.DESC, direction);
  }

  @Test
  void test_getDefaultDirection_WhenNullSortDirection() {
    var direction = getDefaultDirection(null);
    assertNotNull(direction);
    assertEquals(Sort.Direction.ASC, direction);
  }

  @Test
  void test_getDefaultPageNumber_WhenValidPageNumber() {
    var pageNumber = getDefaultPageNumber(10);
    assertEquals(10, pageNumber);
  }

  @Test
  void test_getDefaultPageNumber_WhenNullPageNumber() {
    var pageNumber = getDefaultPageNumber(null);
    assertEquals(DEFAULT_PAGE_NUMBER, pageNumber);
  }

  @Test
  void test_getDefaultPageSize_WhenValidPageNumber() {
    var pageNumber = getDefaultPageSize(2);
    assertEquals(2, pageNumber);
  }

  @Test
  void test_getDefaultPageSize_WhenNullPageNumber() {
    var pageNumber = getDefaultPageSize(null);
    assertEquals(DEFAULT_PAGE_SIZE, pageNumber);
  }
}
