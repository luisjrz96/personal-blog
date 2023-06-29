package com.luisjrz96.blog.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.luisjrz96.blog.data.dto.PostDto;
import com.luisjrz96.blog.data.mapper.PostDtoMapper;
import com.luisjrz96.blog.data.model.Post;
import com.luisjrz96.blog.data.repository.PostRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class DefaultGuestServiceTest {
  @InjectMocks
  private DefaultGuestService defaultGuestService;

  @Mock
  private PostRepository postRepository;

  @Mock
  private PostDtoMapper postDtoMapper;

  @Test
  void test_getAllPosts_WhenRepositoryReturnMultiplePosts() {
    var post = Post.builder().postId(1L).title("Foo Bar").content("Foo content").build();
    var postPage = new PageImpl<>(List.of(post));
    var postDto = PostDto.builder().title("Foo Bar").content("Foo content").build();
    when(postRepository.findAll(Mockito.any(Pageable.class))).thenReturn(postPage);
    when(postDtoMapper.toPostDto(Mockito.any(Post.class))).thenReturn(postDto);

    Page<PostDto> pagePostDto = defaultGuestService.getAllPosts(Pageable.unpaged());

    assertNotNull(pagePostDto);
    assertEquals(1, pagePostDto.getTotalElements());
    assertTrue(pagePostDto.get().findFirst().isPresent());
    assertEquals("Foo Bar", pagePostDto.get().findFirst().get().getTitle());
    assertEquals("Foo content", pagePostDto.get().findFirst().get().getContent());
  }
}
