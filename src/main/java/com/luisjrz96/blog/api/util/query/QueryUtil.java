package com.luisjrz96.blog.api.util.query;

import static com.luisjrz96.blog.util.Util.getDefaultDirection;
import static com.luisjrz96.blog.util.Util.getDefaultPageNumber;
import static com.luisjrz96.blog.util.Util.getDefaultPageSize;
import static com.luisjrz96.blog.util.Util.getDefaultSortAttribute;

import com.luisjrz96.blog.api.exception.InvalidInstantiationException;
import java.lang.reflect.ParameterizedType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Utility class to process the incoming requests.
 */
public class QueryUtil {

  // Disabling instantiation for utility class
  private QueryUtil() {
    throw new InvalidInstantiationException(this.getClass().getName());
  }

  public static Pageable processMultiplePostRequest(Integer pageNumber, Integer pageSize,
      String sortDirection) {
    return PageRequest.of(getDefaultPageNumber(pageNumber), getDefaultPageSize(pageSize),
        getDefaultDirection(sortDirection), getDefaultSortAttribute());
  }

  public static String getTypeClassName(Class<?> clazz, int typeIndex) {
    return ((ParameterizedType) clazz.getGenericSuperclass())
        .getActualTypeArguments()[typeIndex].getTypeName();
  }
}
