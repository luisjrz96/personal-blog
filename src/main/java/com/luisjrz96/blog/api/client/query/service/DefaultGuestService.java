package com.luisjrz96.blog.api.client.query.service;

import com.luisjrz96.blog.api.data.response.dto.PostDto;
import com.luisjrz96.blog.api.data.response.mapper.PostDtoMapper;
import com.luisjrz96.blog.data.persistence.model.Category;
import com.luisjrz96.blog.data.persistence.model.Subcategory;
import com.luisjrz96.blog.data.persistence.model.Tag;
import com.luisjrz96.blog.data.persistence.repository.CategoryRepository;
import com.luisjrz96.blog.data.persistence.repository.PostRepository;
import com.luisjrz96.blog.data.persistence.repository.SubcategoryRepository;
import com.luisjrz96.blog.data.persistence.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultGuestService implements GuestService {

  private final PostRepository postRepository;
  private final CategoryRepository categoryRepository;
  private final TagRepository tagRepository;
  private final SubcategoryRepository subcategoryRepository;
  private final PostDtoMapper postDtoMapper;

  @Override
  public Page<PostDto> getPostPage(Pageable pageable) {
    return postRepository.findAll(pageable).map(postDtoMapper::toPostDto);
  }

  @Override
  public Page<String> getCategoryPage(Pageable pageable) {
    return categoryRepository.findAll(pageable).map(Category::getName);
  }

  @Override
  public Page<String> getTagPage(Pageable pageable) {
    return tagRepository.findAll(pageable).map(Tag::getName);
  }

  @Override
  public Page<String> getSubcategoryPage(Pageable pageable, String categoryName) {
    Page<Subcategory> subcategoryPage;
    if (categoryName != null) {
      subcategoryPage = subcategoryRepository.findByCategoryName(pageable, categoryName);
    } else {
      subcategoryPage = subcategoryRepository.findAll(pageable);
    }
    return subcategoryPage.map(Subcategory::getName);
  }
}
