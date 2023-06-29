package com.luisjrz96.blog.data.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

class RequestProcessorTest {

  @Test
  void test_FailingWhenTryingToInstantiate_RequestProcessor() {
    InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
      Class<?> clazz = RequestProcessor.class;
      Constructor<?> constructor = clazz.getDeclaredConstructor();
      constructor.setAccessible(true);
      constructor.newInstance();
    });
    assertTrue((exception.getTargetException().getMessage().contains("Invalid instantiation")));
  }

  @Test
  void test_processMultiplePostRequest_WithAllInfo() {
    Pageable pageable = RequestProcessor.processMultiplePostRequest(2, 10, "DESC");
    assertNotNull(pageable);
    assertEquals(2, pageable.getPageNumber());
    assertEquals(10, pageable.getPageSize());
    assertEquals(20, pageable.getOffset());
  }

  @Test
  void test_processMultiplePostRequest_WhenNullInput() {
    Pageable pageable = RequestProcessor.processMultiplePostRequest(null, null, null);
    assertNotNull(pageable);
    assertEquals(0, pageable.getPageNumber());
    assertEquals(1, pageable.getPageSize());
    assertEquals(0, pageable.getOffset());
  }
}
