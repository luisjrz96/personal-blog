package com.luisjrz96.blog.api.client.query.service;

import com.luisjrz96.blog.api.data.response.dto.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service used to return information to the users of the blog.
 */
public interface GuestService {

  /**
   * It should return a Page of PostDto which will be showed to the users of the blog.
   *
   * @param pageable request for the repository (Database).
   * @return return a Page of PostDto objects.
   */
  Page<PostDto> getPostPage(Pageable pageable);

  Page<String> getCategoryPage(Pageable pageable);

  Page<String> getTagPage(Pageable pageable);

  Page<String> getSubcategoryPage(Pageable pageable, String categoryName);
}
