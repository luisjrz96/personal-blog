package com.luisjrz96.blog.api.data.request.dto.processor;

import com.luisjrz96.blog.api.data.request.dto.TagRequestDto;
import com.luisjrz96.blog.api.data.request.dto.processor.generic.RequestDtoProcessor;
import com.luisjrz96.blog.data.database.model.Tag;
import java.time.Instant;
import org.springframework.stereotype.Service;

@Service
public class TagDtoProcessor implements RequestDtoProcessor<TagRequestDto, Tag> {

  @Override
  public Tag dtoToEntitySave(TagRequestDto toSave) {
    return Tag.builder().name(toSave.getName()).build();
  }

  @Override
  public Tag dtoToEntityUpdate(TagRequestDto newData, Tag toUpdate) {
    toUpdate.setName(newData.getName());
    toUpdate.setUpdatedDate(Instant.now());
    return toUpdate;
  }
}
