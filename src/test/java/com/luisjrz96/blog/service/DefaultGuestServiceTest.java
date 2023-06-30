package com.luisjrz96.blog.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.luisjrz96.blog.data.dto.PostDto;
import com.luisjrz96.blog.data.mapper.PostDtoMapper;
import com.luisjrz96.blog.data.model.Category;
import com.luisjrz96.blog.data.model.Post;
import com.luisjrz96.blog.data.model.Tag;
import com.luisjrz96.blog.data.repository.CategoryRepository;
import com.luisjrz96.blog.data.repository.PostRepository;
import com.luisjrz96.blog.data.repository.TagRepository;
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
  private CategoryRepository categoryRepository;
  @Mock
  private TagRepository tagRepository;
  @Mock
  private PostDtoMapper postDtoMapper;

  @Test
  void test_getPostPage_WhenRepositoryReturnMultiplePosts() {
    var post = Post.builder().postId(1L).title("Foo Bar").content("Foo content").build();
    var postPage = new PageImpl<>(List.of(post));
    var postDto = PostDto.builder().title("Foo Bar").content("Foo content").build();
    when(postRepository.findAll(Mockito.any(Pageable.class))).thenReturn(postPage);
    when(postDtoMapper.toPostDto(Mockito.any(Post.class))).thenReturn(postDto);

    Page<PostDto> pagePostDto = defaultGuestService.getPostPage(Pageable.unpaged());

    assertNotNull(pagePostDto);
    assertEquals(1, pagePostDto.getTotalElements());
    assertTrue(pagePostDto.get().findFirst().isPresent());
    assertEquals("Foo Bar", pagePostDto.get().findFirst().get().getTitle());
    assertEquals("Foo content", pagePostDto.get().findFirst().get().getContent());
  }

  @Test
  void test_getCategoryPage_WhenRepositoryReturnMultipleCategories() {
    List<Category> categoryList = List.of(Category.builder().name("Java").build(),
        Category.builder().name("DevOps").build(), Category.builder().name("Networks").build());
    when(categoryRepository.findAll(Mockito.any(Pageable.class)))
        .thenReturn(new PageImpl<>(categoryList));

    Page<String> categoryPage = defaultGuestService.getCategoryPage(Pageable.unpaged());
    assertNotNull(categoryPage);
    assertEquals(1, categoryPage.getTotalPages());
    assertNotNull(categoryPage.getContent());
    assertThat(categoryPage.getContent(), hasItems("Java", "DevOps", "Networks"));
  }

  @Test
  void test_getTagPage_WhenRepositoryReturnMultipleTags() {
    List<Tag> tagList = List.of(Tag.builder().name("Awesome").build(),
        Tag.builder().name("Cool").build(), Tag.builder().name("Easy").build());
    when(tagRepository.findAll(Mockito.any(Pageable.class)))
        .thenReturn(new PageImpl<>(tagList));

    Page<String> categoryPage = defaultGuestService.getTagPage(Pageable.unpaged());
    assertNotNull(categoryPage);
    assertEquals(1, categoryPage.getTotalPages());
    assertNotNull(categoryPage.getContent());
    assertThat(categoryPage.getContent(), hasItems("Awesome", "Cool", "Easy"));
  }
}
