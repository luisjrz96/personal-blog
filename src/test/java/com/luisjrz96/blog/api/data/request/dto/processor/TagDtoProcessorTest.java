package com.luisjrz96.blog.api.data.request.dto.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.luisjrz96.blog.api.data.request.dto.TagRequestDto;
import com.luisjrz96.blog.data.persistence.model.Tag;
import org.junit.jupiter.api.Test;

class TagDtoProcessorTest {

  private final TagDtoProcessor tagDtoProcessor = new TagDtoProcessor();

  @Test
  void test_dtoToEntitySave_Success() {
    TagRequestDto tagRequestDto = new TagRequestDto();
    tagRequestDto.setName("Development");
    var tag = tagDtoProcessor.dtoToEntitySave(tagRequestDto);
    assertEquals("Development", tag.getName());
  }

  @Test
  void test_dtoToEntityUpdate_Success() {
    TagRequestDto tagRequestDto = new TagRequestDto();
    tagRequestDto.setName("Development");

    Tag toUpdate = Tag.builder().tagId(1L).name("Coding").build();
    var tag = tagDtoProcessor.dtoToEntityUpdate(tagRequestDto, toUpdate);
    assertEquals("Development", tag.getName());
    assertEquals(1L, toUpdate.getTagId());
  }
}
