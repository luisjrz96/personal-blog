package com.luisjrz96.blog.util;

import com.luisjrz96.blog.api.exception.InvalidInstantiationException;
import org.springframework.data.domain.Sort;

public class Constants {

  // Disabling instantiation for utility class
  private Constants() {
    throw new InvalidInstantiationException(this.getClass().getName());
  }

  public static final String PAGE_SIZE = "pageSize";
  public static final String PAGE_NUMBER = "pageNumber";
  //public static final String SORT_ATTRIBUTE = "sortAttribute"; // REQUIRES IMPLEMENTATION
  public static final String SORT_DIRECTION = "sortDirection";
  public static final int DEFAULT_PAGE_SIZE = 1;
  public static final int DEFAULT_PAGE_NUMBER = 0;
  public static final String CATEGORY_NAME = "categoryName";
  public static final String DEFAULT_SORT_ATTRIBUTE = "createdDate";
  public static final Sort.Direction DEFAULT_SORT_DIRECTION = Sort.Direction.ASC;

  // ADMIN PATHS
  public static final String ADMIN_CATEGORIES_PATH = "/api/admin/categories";
  public static final String ADMIN_TAGS_PATH = "/api/admin/tags";
  public static final String ADMIN_SUBCATEGORIES_PATH = "/api/admin/subcategories";


}
