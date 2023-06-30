package com.luisjrz96.blog.data.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

import com.luisjrz96.blog.data.dto.PostDto;
import com.luisjrz96.blog.data.model.Post;
import com.luisjrz96.blog.data.model.PostTag;
import com.luisjrz96.blog.data.model.Subcategory;
import com.luisjrz96.blog.data.model.Tag;
import java.util.List;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = SPRING, nullValueCheckStrategy = ALWAYS)
public interface PostDtoMapper {

  @Mapping(target = "category", source = "post.subcategory.category.name")
  @Mapping(target = "tags", source = "post", qualifiedByName = "setTags")
  PostDto toPostDto(Post post);

  /**
   * Return the name of the subcategory related to the post.
   *
   * @param subcategory Subcategory to check for the name.
   * @return Returns the subcategory name related to the post, if there is no related subcategory
   *     to the post it returns null.
   */
  static String setSubcategory(Subcategory subcategory) {
    return subcategory.getName();
  }

  /**
   * Obtain the list of tags related to a specific post.
   *
   * @param post Post to check the tags.
   * @return Returns the list of tags related to the post, default return is empty list.
   */
  @Named("setTags")
  static List<String> setTags(Post post) {
    return Optional.ofNullable(post).map(Post::getPostTagList).stream().flatMap(List::stream)
        .map(PostTag::getTag).map(Tag::getName).toList();
  }

}
