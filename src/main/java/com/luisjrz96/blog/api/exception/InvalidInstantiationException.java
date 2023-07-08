package com.luisjrz96.blog.api.exception;

/**
 * Exception returned when a class with private constructor is instantiated.
 */
public class InvalidInstantiationException extends RuntimeException {

  public static final String INVALID_INSTANTIATION_EXCEPTION_MESSAGE =
      "Invalid instantiation for class: %s";

  public InvalidInstantiationException(String className) {
    super(String.format(INVALID_INSTANTIATION_EXCEPTION_MESSAGE, className));
  }
}
