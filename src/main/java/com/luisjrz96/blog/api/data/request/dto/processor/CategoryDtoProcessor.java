package com.luisjrz96.blog.api.data.request.dto.processor;

import com.luisjrz96.blog.api.data.request.dto.CategoryRequestDto;
import com.luisjrz96.blog.api.data.request.dto.processor.generic.RequestDtoProcessor;
import com.luisjrz96.blog.data.persistence.model.Category;
import java.time.Instant;
import org.springframework.stereotype.Service;

@Service
public class CategoryDtoProcessor implements RequestDtoProcessor<CategoryRequestDto, Category> {

  @Override
  public Category dtoToEntitySave(CategoryRequestDto toSave) {
    return Category.builder()
        .name(toSave.getName())
        .build();
  }

  @Override
  public Category dtoToEntityUpdate(CategoryRequestDto newData, Category toUpdate) {
    toUpdate.setName(newData.getName());
    toUpdate.setUpdatedDate(Instant.now());
    return toUpdate;
  }
}
