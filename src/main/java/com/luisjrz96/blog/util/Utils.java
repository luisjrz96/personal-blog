package com.luisjrz96.blog.util;


import static com.luisjrz96.blog.util.Constants.DEFAULT_PAGE_NUMBER;
import static com.luisjrz96.blog.util.Constants.DEFAULT_PAGE_SIZE;
import static com.luisjrz96.blog.util.Constants.DEFAULT_SORT_ATTRIBUTE;
import static com.luisjrz96.blog.util.Constants.DEFAULT_SORT_DIRECTION;

import com.luisjrz96.blog.exception.InvalidInstantiationException;
import java.util.Optional;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.data.domain.Sort;

public class Utils {

  // Disabling instantiation for utility class
  private Utils() {
    throw new InvalidInstantiationException(Utils.class.getName());
  }

  /**
   * Returns the sort direction depending on the input, if the input is a valid
   * direction type it will return provided sort direction, otherwise, it returns ASC.
   *
   * @param sortDirection sort direction to check.
   * @return direction ASC/DESC, default: ASC
   */
  public static Sort.Direction getDefaultDirection(String sortDirection) {
    Sort.Direction direction;
    if (EnumUtils.isValidEnum(Sort.Direction.class, sortDirection)) {
      direction = EnumUtils.getEnum(Sort.Direction.class, sortDirection);
    } else {
      direction = DEFAULT_SORT_DIRECTION;
    }
    return direction;
  }

  public static String getDefaultSortAttribute() {
    // TODO: create enum of sorting attributes and then implement logic
    return DEFAULT_SORT_ATTRIBUTE;
  }

  /**
   * Returns a positive number or zero.
   * @param pageNumber integer value.
   * @return it returns a positive integer, default value: 0.
   */
  public static int getDefaultPageNumber(Integer pageNumber) {
    return Optional.ofNullable(pageNumber).orElse(DEFAULT_PAGE_NUMBER);
  }

  /**
   * Returns a positive number.
   * @param pageSize integer value.
   * @return it returns a positive integer, default value: 1.
   */
  public static int getDefaultPageSize(Integer pageSize) {
    return Optional.ofNullable(pageSize).orElse(DEFAULT_PAGE_SIZE);
  }
}
