package com.luisjrz96.blog.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luisjrz96.blog.data.dto.PostDto;
import com.luisjrz96.blog.data.dto.RestPage;
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
  void testGetPost_WhenMultipleAvailablePosts() throws Exception {
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

}
