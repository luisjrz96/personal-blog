package com.luisjrz96.blog.api.client.query.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luisjrz96.blog.api.client.query.controller.GuestController;
import com.luisjrz96.blog.api.data.response.dto.PostDto;
import com.luisjrz96.blog.api.data.response.dto.RestPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class GuestControllerIntegrationTest {

  @Autowired
  private GuestController guestController;

  @Autowired
  private ObjectMapper objectMapper;

  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(guestController).build();
  }

  @Test
  @Transactional
  void test_getPostPages_WhenMultipleAvailablePosts() throws Exception {
    // Database should be populated using import.sql file
    MvcResult mvcResult = mockMvc.perform(get("/blog/posts?pageNumber=0&pageSize=2"
            + "&sortDirection=ASC"))
        .andExpect(status().isOk())
        .andReturn();

    RestPage<PostDto> postDtoPage =
        objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
            new TypeReference<RestPage<PostDto>>() {});

    assertNotNull(mvcResult.getResponse().getContentAsString());
    assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    assertEquals(1, postDtoPage.getTotalPages());
    assertEquals(2, postDtoPage.getTotalElements());
    assertEquals(0, postDtoPage.getPageable().getOffset());
    assertNotNull(postDtoPage.getContent().get(0));
    assertTrue(postDtoPage.getContent().get(0).getTitle().contains("Spring Boot 3.0"));
    assertNotNull(postDtoPage.getContent().get(1));
    assertTrue(postDtoPage.getContent().get(1).getTitle().contains("Foo bar"));
  }

  @Test
  @Transactional
  void test_getCategoryPages_WhenMultipleAvailableCategories() throws Exception {
    // Database should be populated using import.sql file
    MvcResult mvcResult = mockMvc.perform(get("/blog/categories?pageNumber=0&pageSize=10"
            + "&sortDirection=ASC"))
        .andExpect(status().isOk())
        .andReturn();

    RestPage<String> categoryPage =
        objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
            new TypeReference<RestPage<String>>() {});

    assertNotNull(mvcResult.getResponse().getContentAsString());
    assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    assertEquals(1, categoryPage.getTotalPages());
    assertEquals(4, categoryPage.getTotalElements());
    assertEquals(0, categoryPage.getPageable().getOffset());
    assertNotNull(categoryPage.getContent().get(0));
    assertThat(categoryPage.getContent(), hasItems("Java", "Go", "Python", "Databases"));
  }

  @Test
  @Transactional
  void test_getTagPages_WhenMultipleAvailableTags() throws Exception {
    // Database should be populated using import.sql file
    MvcResult mvcResult = mockMvc.perform(get("/blog/tags?pageNumber=0&pageSize=10"
            + "&sortDirection=ASC"))
        .andExpect(status().isOk())
        .andReturn();

    RestPage<String> categoryPage =
        objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
            new TypeReference<RestPage<String>>() {});

    assertNotNull(mvcResult.getResponse().getContentAsString());
    assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    assertEquals(1, categoryPage.getTotalPages());
    assertEquals(3, categoryPage.getTotalElements());
    assertEquals(0, categoryPage.getPageable().getOffset());
    assertNotNull(categoryPage.getContent().get(0));
    assertThat(categoryPage.getContent(), hasItems("Development", "Practice", "Powerful"));
  }

  @Test
  @Transactional
  void test_getSubcategoryPages_WhenNonSpecificCategoryAndMultipleResultsFromService()
      throws Exception {
    // Database should be populated using import.sql file
    MvcResult mvcResult = mockMvc.perform(get("/blog/subcategories?pageNumber=0"
            + "&pageSize=10&sortDirection=ASC"))
        .andExpect(status().isOk())
        .andReturn();

    RestPage<String> subcategoryPage =
        objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
            new TypeReference<RestPage<String>>() {});

    assertNotNull(mvcResult.getResponse().getContentAsString());
    assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    assertEquals(1, subcategoryPage.getTotalPages());
    assertEquals(5, subcategoryPage.getTotalElements());
    assertEquals(0, subcategoryPage.getPageable().getOffset());
    assertNotNull(subcategoryPage.getContent().get(0));
    assertThat(subcategoryPage.getContent(), hasItems("Spring Boot", "Annotations", "Stream API",
        "Go Routines", "Generics"));
  }

  @Test
  @Transactional
  void test_getSubcategoryPages_WhenSpecificCategoryAndMultipleResultsFromService()
      throws Exception {
    // Database should be populated using import.sql file
    MvcResult mvcResult = mockMvc.perform(get("/blog/subcategories?pageNumber=0"
            + "&pageSize=10&sortDirection=ASC&categoryName=Go"))
        .andExpect(status().isOk())
        .andReturn();

    RestPage<String> subcategoryPage =
        objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
            new TypeReference<RestPage<String>>() {});

    assertNotNull(mvcResult.getResponse().getContentAsString());
    assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    assertEquals(1, subcategoryPage.getTotalPages());
    assertEquals(2, subcategoryPage.getTotalElements());
    assertEquals(0, subcategoryPage.getPageable().getOffset());
    assertNotNull(subcategoryPage.getContent().get(0));
    assertThat(subcategoryPage.getContent(), hasItems("Go Routines", "Generics"));
  }
}
