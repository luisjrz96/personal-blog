package com.luisjrz96.blog.api.client.query.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.luisjrz96.blog.api.client.query.controller.GuestController;
import com.luisjrz96.blog.api.client.query.service.GuestService;
import com.luisjrz96.blog.api.data.response.dto.PostDto;
import com.luisjrz96.blog.api.data.response.dto.RestPage;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class GuestControllerTest {

  @InjectMocks
  private GuestController guestController;
  @Mock
  private GuestService guestService;

  @Test
  void test_getPostPages_WhenGuestServiceReturnMultiplePosts() {
    ArgumentCaptor<Pageable> pageableArgumentCaptor = ArgumentCaptor.forClass(Pageable.class);
    List<PostDto> postDtoList = List.of(PostDto.builder().title("Post 1")
            .content("Post 1 content").build(),
        PostDto.builder().title("Post 2").content("Post 2 content").build());
    var pagePostDto = new PageImpl<>(postDtoList);

    when(guestService.getPostPage(pageableArgumentCaptor.capture()))
        .thenReturn(pagePostDto);
    ResponseEntity<RestPage<PostDto>> responseEntityResult = guestController
        .getPostPages(0, 2, "ABC");

    assertNotNull(responseEntityResult);
    assertNotNull(responseEntityResult.getBody());
    assertEquals(0, pageableArgumentCaptor.getValue().getPageNumber());
    assertEquals(2, pageableArgumentCaptor.getValue().getPageSize());
    assertEquals(2, responseEntityResult.getBody().get().count());
    assertNotNull(responseEntityResult.getBody().getContent().get(0));
    assertNotNull(responseEntityResult.getBody().getContent().get(0).getTitle());
    assertTrue(responseEntityResult.getBody().getContent().get(0).getTitle().contains("Post 1"));
  }

  @Test
  void test_getCategoryPages_WhenGuestServiceReturnMultipleCategories() {
    ArgumentCaptor<Pageable> pageableArgumentCaptor = ArgumentCaptor.forClass(Pageable.class);
    List<String> categoryList = List.of("Java", "DevOps", "Networks");
    var pageCategories = new PageImpl<>(categoryList);

    when(guestService.getCategoryPage(pageableArgumentCaptor.capture()))
        .thenReturn(pageCategories);
    ResponseEntity<RestPage<String>> responseEntityResult = guestController
        .getCategoryPages(0, 2, "ABC");

    assertNotNull(responseEntityResult);
    assertNotNull(responseEntityResult.getBody());
    assertEquals(0, pageableArgumentCaptor.getValue().getPageNumber());
    assertEquals(2, pageableArgumentCaptor.getValue().getPageSize());
    assertEquals(3, responseEntityResult.getBody().get().count());
    assertNotNull(responseEntityResult.getBody().getContent().get(0));
    assertThat(responseEntityResult.getBody().getContent(), hasItems("Java", "DevOps", "Networks"));
  }

  @Test
  void test_getTagPages_WhenGuestServiceReturnMultipleTags() {
    ArgumentCaptor<Pageable> pageableArgumentCaptor = ArgumentCaptor.forClass(Pageable.class);
    List<String> tagList = List.of("Awesome", "Cool", "Easy");
    var pageTags = new PageImpl<>(tagList);

    when(guestService.getTagPage(pageableArgumentCaptor.capture()))
        .thenReturn(pageTags);
    ResponseEntity<RestPage<String>> responseEntityResult = guestController
        .getTagPages(0, 2, "ABC");

    assertNotNull(responseEntityResult);
    assertNotNull(responseEntityResult.getBody());
    assertEquals(0, pageableArgumentCaptor.getValue().getPageNumber());
    assertEquals(2, pageableArgumentCaptor.getValue().getPageSize());
    assertEquals(3, responseEntityResult.getBody().get().count());
    assertNotNull(responseEntityResult.getBody().getContent().get(0));
    assertThat(responseEntityResult.getBody().getContent(), hasItems("Awesome", "Cool",
        "Easy"));
  }

  @Test
  void test_getSubcategoryPages_WhenServiceReturnMultipleSubcategories() {
    ArgumentCaptor<Pageable> pageableArgumentCaptor = ArgumentCaptor.forClass(Pageable.class);
    List<String> tagList = List.of("Spring Boot", "Streams");
    var pageSubcategories = new PageImpl<>(tagList);

    when(guestService.getSubcategoryPage(pageableArgumentCaptor.capture(),
        Mockito.nullable(String.class)))
        .thenReturn(pageSubcategories);
    ResponseEntity<RestPage<String>> responseEntityResult = guestController
        .getSubcategoryPages(0, 2, "ABC", null);

    assertNotNull(responseEntityResult);
    assertNotNull(responseEntityResult.getBody());
    assertEquals(0, pageableArgumentCaptor.getValue().getPageNumber());
    assertEquals(2, pageableArgumentCaptor.getValue().getPageSize());
    assertEquals(2, responseEntityResult.getBody().get().count());
    assertNotNull(responseEntityResult.getBody().getContent().get(0));
    assertThat(responseEntityResult.getBody().getContent(), hasItems("Spring Boot", "Streams"));
  }

}
