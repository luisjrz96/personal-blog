package com.luisjrz96.blog.data.utils;

import static com.luisjrz96.blog.util.Utils.getDefaultDirection;
import static com.luisjrz96.blog.util.Utils.getDefaultPageNumber;
import static com.luisjrz96.blog.util.Utils.getDefaultPageSize;
import static com.luisjrz96.blog.util.Utils.getDefaultSortAttribute;

import com.luisjrz96.blog.exception.InvalidInstantiationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Utility class to process the incoming requests.
 */
public class RequestProcessor {

  // Disabling instantiation for utility class
  private RequestProcessor() {
    throw new InvalidInstantiationException(this.getClass().getName());
  }

  public static Pageable processMultiplePostRequest(Integer pageNumber, Integer pageSize,
      String sortDirection) {
    return PageRequest.of(getDefaultPageNumber(pageNumber), getDefaultPageSize(pageSize),
        getDefaultDirection(sortDirection), getDefaultSortAttribute());
  }
}
