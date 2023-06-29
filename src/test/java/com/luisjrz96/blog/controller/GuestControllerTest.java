package com.luisjrz96.blog.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.luisjrz96.blog.data.dto.PostDto;
import com.luisjrz96.blog.data.dto.RestPage;
import com.luisjrz96.blog.service.GuestService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
  void test_getAllPosts_WhenMultipleServiceReturnMultiplePosts() {
    ArgumentCaptor<Pageable> pageableArgumentCaptor = ArgumentCaptor.forClass(Pageable.class);
    List<PostDto> postDtoList = List.of(PostDto.builder().title("Post 1")
            .content("Post 1 content").build(),
        PostDto.builder().title("Post 2").content("Post 2 content").build());
    var pagePostDto = new PageImpl<>(postDtoList);

    when(guestService.getAllPosts(pageableArgumentCaptor.capture()))
        .thenReturn(pagePostDto);
    ResponseEntity<RestPage<PostDto>> responseEntityResult = guestController
        .getAllPosts(0, 2, "ABC");

    assertNotNull(responseEntityResult);
    assertNotNull(responseEntityResult.getBody());
    assertEquals(2, responseEntityResult.getBody().get().count());
    assertEquals(2, pageableArgumentCaptor.getValue().getPageSize());
    assertEquals(0, pageableArgumentCaptor.getValue().getPageNumber());
    assertNotNull(responseEntityResult.getBody().getContent().get(0));
    assertNotNull(responseEntityResult.getBody().getContent().get(0).getTitle());
    assertTrue(responseEntityResult.getBody().getContent().get(0).getTitle().contains("Post 1"));
  }

}
