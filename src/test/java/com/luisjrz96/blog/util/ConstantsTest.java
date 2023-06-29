package com.luisjrz96.blog.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

class ConstantsTest {

  @Test
  void test_FailingWhenTryingToInstantiate_Constants() {
    InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> {
      Class<?> clazz = Constants.class;
      Constructor<?> constructor = clazz.getDeclaredConstructor();
      constructor.setAccessible(true);
      constructor.newInstance();
    });
    assertTrue((exception.getTargetException().getMessage().contains("Invalid instantiation")));
  }
}
