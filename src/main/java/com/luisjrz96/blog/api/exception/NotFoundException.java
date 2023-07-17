package com.luisjrz96.blog.api.exception;

public class NotFoundException extends RuntimeException {

  public static final String NOT_FOUND_MESSAGE = "%s with id %s not found";

  public NotFoundException(String className, String id) {
    super(String.format(NOT_FOUND_MESSAGE, className, id));
  }

  public NotFoundException(String message) {
    super(message);
  }
}
