package com.luisjrz96.blog.api.client.query.controller;

import static com.luisjrz96.blog.util.Constants.CATEGORY_NAME;
import static com.luisjrz96.blog.util.Constants.PAGE_NUMBER;
import static com.luisjrz96.blog.util.Constants.PAGE_SIZE;
import static com.luisjrz96.blog.util.Constants.SORT_DIRECTION;

import com.luisjrz96.blog.api.client.query.service.GuestService;
import com.luisjrz96.blog.api.data.response.dto.PostDto;
import com.luisjrz96.blog.api.data.response.dto.RestPage;
import com.luisjrz96.blog.api.util.query.QueryUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/blog")
@RestController
@Validated
public class GuestController {

  private final GuestService guestService;

  @GetMapping("/posts")
  ResponseEntity<RestPage<PostDto>> getPostPages(
      @RequestParam(name = PAGE_NUMBER, required = false) Integer pageNumber,
      @RequestParam(name = PAGE_SIZE, required = false) Integer pageSize,
      @RequestParam(name = SORT_DIRECTION, required = false) String sortDirection) {

    return ResponseEntity.ok(
        new RestPage<>(guestService.getPostPage(QueryUtil.processMultiplePostRequest(
            pageNumber,
            pageSize,
            sortDirection))));
  }

  @GetMapping("/categories")
  ResponseEntity<RestPage<String>> getCategoryPages(
      @RequestParam(name = PAGE_NUMBER, required = false) Integer pageNumber,
      @RequestParam(name = PAGE_SIZE, required = false) Integer pageSize,
      @RequestParam(name = SORT_DIRECTION, required = false) String sortDirection) {

    return ResponseEntity.ok(
        new RestPage<>(guestService.getCategoryPage(QueryUtil.processMultiplePostRequest(
            pageNumber,
            pageSize,
            sortDirection))));
  }

  @GetMapping("/tags")
  ResponseEntity<RestPage<String>> getTagPages(
      @RequestParam(name = PAGE_NUMBER, required = false) Integer pageNumber,
      @RequestParam(name = PAGE_SIZE, required = false) Integer pageSize,
      @RequestParam(name = SORT_DIRECTION, required = false) String sortDirection) {

    return ResponseEntity.ok(
        new RestPage<>(guestService.getTagPage(QueryUtil.processMultiplePostRequest(
            pageNumber,
            pageSize,
            sortDirection))));
  }

  @GetMapping("/subcategories")
  ResponseEntity<RestPage<String>> getSubcategoryPages(
      @RequestParam(name = PAGE_NUMBER, required = false) Integer pageNumber,
      @RequestParam(name = PAGE_SIZE, required = false) Integer pageSize,
      @RequestParam(name = SORT_DIRECTION, required = false) String sortDirection,
      @RequestParam(name = CATEGORY_NAME, required = false) String categoryName) {

    return ResponseEntity.ok(
        new RestPage<>(guestService.getSubcategoryPage(QueryUtil.processMultiplePostRequest(
            pageNumber,
            pageSize,
            sortDirection), categoryName)));
  }
}
