package com.luisjrz96.blog.api.data.request.dto.processor;

import com.luisjrz96.blog.api.data.request.dto.SubcategoryRequestDto;
import com.luisjrz96.blog.api.data.request.dto.processor.generic.RequestDtoProcessor;
import com.luisjrz96.blog.api.exception.NotFoundException;
import com.luisjrz96.blog.data.persistence.model.Category;
import com.luisjrz96.blog.data.persistence.model.Subcategory;
import com.luisjrz96.blog.data.persistence.repository.CategoryRepository;
import java.time.Instant;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubcategoryDtoProcessor implements RequestDtoProcessor<SubcategoryRequestDto,
    Subcategory> {

  private final CategoryRepository categoryRepository;
  private static final String NOT_FOUND_BY_NAME = "Category with name \"%s\" not found";

  @Override
  public Subcategory dtoToEntitySave(SubcategoryRequestDto toSave) {
    var category = categoryRepository.findByName(toSave.getCategoryName()).orElseThrow(() ->
        new NotFoundException(String.format(NOT_FOUND_BY_NAME, toSave.getName())));
    return Subcategory.builder()
        .category(category)
        .name(toSave.getName())
        .build();
  }

  @Override
  public Subcategory dtoToEntityUpdate(SubcategoryRequestDto newData, Subcategory toUpdate) {
    updateCategory(newData, toUpdate);
    toUpdate.setName(newData.getName());
    toUpdate.setUpdatedDate(Instant.now());
    return toUpdate;
  }

  private void updateCategory(SubcategoryRequestDto newData, Subcategory toUpdate) {
    Optional<Category> category = Optional.empty();
    if (requiresCategoryUpdate(newData, toUpdate)) {
      category = categoryRepository.findByName(newData.getCategoryName());
    }
    if (toUpdate != null) {
      category.ifPresent(toUpdate::setCategory);
    }
  }

  private boolean requiresCategoryUpdate(SubcategoryRequestDto newData, Subcategory toUpdate) {
    String currentCategoryName = Optional.ofNullable(toUpdate)
        .map(Subcategory::getCategory)
        .map(Category::getName).orElse(null);

    String newCategoryName = Optional.ofNullable(newData)
        .map(SubcategoryRequestDto::getCategoryName).orElse(null);

    return newCategoryName != null
        && currentCategoryName != null
        && !newCategoryName.equals(currentCategoryName);
  }
}
