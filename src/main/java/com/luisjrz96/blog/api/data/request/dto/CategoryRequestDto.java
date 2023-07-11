package com.luisjrz96.blog.api.data.request.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Generated;
import org.springframework.validation.annotation.Validated;

@Generated
@Validated
@Data
public class CategoryRequestDto {

  @NotBlank(message = "category name must not be empty")
  private String name;

}
