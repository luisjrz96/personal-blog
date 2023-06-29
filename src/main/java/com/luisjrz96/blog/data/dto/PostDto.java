package com.luisjrz96.blog.data.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Generated
@Data
@Builder
public class PostDto implements Serializable {

  private String title;
  private String content;
  private List<String> tags;
  private String category;
  private String subcategory;
  private Instant createdDate;
}
