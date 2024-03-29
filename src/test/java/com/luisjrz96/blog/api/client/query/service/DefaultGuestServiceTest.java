package com.luisjrz96.blog.api.client.query.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.luisjrz96.blog.api.client.query.service.DefaultGuestService;
import com.luisjrz96.blog.api.data.response.dto.PostDto;
import com.luisjrz96.blog.api.data.response.mapper.PostDtoMapper;
import com.luisjrz96.blog.data.persistence.model.Category;
import com.luisjrz96.blog.data.persistence.model.Post;
import com.luisjrz96.blog.data.persistence.model.Subcategory;
import com.luisjrz96.blog.data.persistence.model.Tag;
import com.luisjrz96.blog.data.persistence.repository.CategoryRepository;
import com.luisjrz96.blog.data.persistence.repository.PostRepository;
import com.luisjrz96.blog.data.persistence.repository.SubcategoryRepository;
import com.luisjrz96.blog.data.persistence.repository.TagRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
  private SubcategoryRepository subcategoryRepository;
  @Mock
  private PostDtoMapper postDtoMapper;

  @Test
  void test_getPostPage_WhenRepositoryReturnMultiplePosts() {
    var post = Post.builder().postId(1L).title("Foo Bar").content("Foo content").build();
    var postPage = new PageImpl<>(List.of(post));
    var postDto = PostDto.builder().title("Foo Bar").content("Foo content").build();
    when(postRepository.findAll(any(Pageable.class))).thenReturn(postPage);
    when(postDtoMapper.toPostDto(any(Post.class))).thenReturn(postDto);

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
    when(categoryRepository.findAll(any(Pageable.class)))
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
    when(tagRepository.findAll(any(Pageable.class)))
        .thenReturn(new PageImpl<>(tagList));

    Page<String> categoryPage = defaultGuestService.getTagPage(Pageable.unpaged());
    assertNotNull(categoryPage);
    assertEquals(1, categoryPage.getTotalPages());
    assertNotNull(categoryPage.getContent());
    assertThat(categoryPage.getContent(), hasItems("Awesome", "Cool", "Easy"));
  }

  @Test
  void test_getSubcategoryPage_WhenNonSpecificCategoryAndRepositoryReturnMultipleSubcategories() {
    List<Subcategory> subcategoryList = List.of(Subcategory.builder().name("Spring Boot").build(),
        Subcategory.builder().name("Streams").build());
    when(subcategoryRepository.findAll(any(Pageable.class)))
        .thenReturn(new PageImpl<>(subcategoryList));

    Page<String> subcategoryPage = defaultGuestService.getSubcategoryPage(Pageable.unpaged(), null);
    assertNotNull(subcategoryPage);
    assertEquals(1, subcategoryPage.getTotalPages());
    assertNotNull(subcategoryPage.getContent());
    assertThat(subcategoryPage.getContent(), hasItems("Spring Boot", "Streams"));
  }

  @Test
  void test_getSubcategoryPage_ForSpecificCategoryAndRepositoryReturnMultipleSubcategories() {
    List<Subcategory> subcategoryList = List.of(Subcategory.builder().name("Spring Boot").build(),
        Subcategory.builder().name("Streams").build());
    when(subcategoryRepository.findByCategoryName(any(Pageable.class), any()))
        .thenReturn(new PageImpl<>(subcategoryList));

    Page<String> subcategoryPage = defaultGuestService.getSubcategoryPage(Pageable.unpaged(),
        "Java");
    assertNotNull(subcategoryPage);
    assertEquals(1, subcategoryPage.getTotalPages());
    assertNotNull(subcategoryPage.getContent());
    assertThat(subcategoryPage.getContent(), hasItems("Spring Boot", "Streams"));
  }
}
