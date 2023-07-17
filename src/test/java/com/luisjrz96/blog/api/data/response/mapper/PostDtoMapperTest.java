package com.luisjrz96.blog.api.data.response.mapper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.luisjrz96.blog.data.persistence.model.Category;
import com.luisjrz96.blog.data.persistence.model.Post;
import com.luisjrz96.blog.data.persistence.model.PostTag;
import com.luisjrz96.blog.data.persistence.model.Subcategory;
import com.luisjrz96.blog.data.persistence.model.Tag;
import com.luisjrz96.blog.data.persistence.model.User;
import java.time.Instant;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PostDtoMapperImpl.class)
class PostDtoMapperTest {

  @Autowired
  private PostDtoMapper postDtoMapper;

  @Test
  void test_toPostDto_GivenNullPost() {
    assertDoesNotThrow(() -> {
      postDtoMapper.toPostDto(null);
    });
  }

  @Test
  void test_toPostDto_GivenEmptyPost() {
    assertDoesNotThrow(() -> {
      postDtoMapper.toPostDto(Post.builder().build());
    });
  }

  @Test
  void test_toPostDto_MappingWithAllInformation() {
    var post = Post.builder().postId(1L).title("Title").content("Content")
        .user(User.builder().userId(1L).email("foo@bar.com").username("foo")
            .password("supersecret").build())
        .subcategory(Subcategory.builder().subcategoryId(1L).name("Spring Boot")
            .category(Category.builder().categoryId(1L).name("Java").build())
            .build()).build();
    post.setCreatedDate(Instant.now());
    var tag = Tag.builder().tagId(1L).name("Cool").build();
    var postTagList = List.of(PostTag.builder().post(post).tag(tag).build());
    post.setPostTagList(postTagList);
    var postDto = postDtoMapper.toPostDto(post);
    assertEquals("Title", postDto.getTitle());
    assertEquals("Content", postDto.getContent());
    assertEquals("Java", postDto.getCategory());
    assertEquals("Spring Boot", postDto.getSubcategory());
  }

  @Test
  void test_toPostDto_MappingWithNoCategory() {
    var post = Post.builder().postId(1L).title("Title").content("Content")
        .user(User.builder().userId(1L).email("foo@bar.com").username("foo")
            .password("supersecret").build())
        .subcategory(Subcategory.builder().subcategoryId(1L).name("Spring Boot")
            .build())
        .build();
    post.setCreatedDate(Instant.now());
    var tag = Tag.builder().tagId(1L).name("Cool").build();
    var postTagList = List.of(PostTag.builder().post(post).tag(tag).build());
    post.setPostTagList(postTagList);
    var postDto = postDtoMapper.toPostDto(post);
    assertEquals("Title", postDto.getTitle());
    assertEquals("Content", postDto.getContent());
    assertNull(postDto.getCategory());
    assertEquals("Spring Boot", postDto.getSubcategory());
  }

  @Test
  void test_toPostDto_MappingWithCategoryHavingNullName() {
    var post = Post.builder().postId(1L).title("Title").content("Content")
        .user(User.builder().userId(1L).email("foo@bar.com").username("foo")
            .password("supersecret").build())
        .subcategory(Subcategory.builder().subcategoryId(1L).name("Spring Boot")
            .category(Category.builder().build()).build())
        .build();
    post.setCreatedDate(Instant.now());
    var tag = Tag.builder().tagId(1L).name("Cool").build();
    var postTagList = List.of(PostTag.builder().post(post).tag(tag).build());
    post.setPostTagList(postTagList);
    var postDto = postDtoMapper.toPostDto(post);
    assertEquals("Title", postDto.getTitle());
    assertEquals("Content", postDto.getContent());
    assertNull(postDto.getCategory());
    assertEquals("Spring Boot", postDto.getSubcategory());
  }

  @Test
  void test_toPostDto_MappingWithNoSubcategory() {
    var post = Post.builder().postId(1L).title("Title").content("Content")
        .user(User.builder().userId(1L).email("foo@bar.com").username("foo")
            .password("supersecret").build())
        .build();
    post.setCreatedDate(Instant.now());
    var tag = Tag.builder().tagId(1L).name("Cool").build();
    var postTagList = List.of(PostTag.builder().post(post).tag(tag).build());
    post.setPostTagList(postTagList);
    var postDto = postDtoMapper.toPostDto(post);
    assertEquals("Title", postDto.getTitle());
    assertEquals("Content", postDto.getContent());
    assertNull(postDto.getCategory());
    assertNull(postDto.getSubcategory());
  }

}
