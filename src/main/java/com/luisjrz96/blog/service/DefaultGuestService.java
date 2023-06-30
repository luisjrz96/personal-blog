package com.luisjrz96.blog.service;

import com.luisjrz96.blog.data.dto.PostDto;
import com.luisjrz96.blog.data.mapper.PostDtoMapper;
import com.luisjrz96.blog.data.model.Category;
import com.luisjrz96.blog.data.model.Tag;
import com.luisjrz96.blog.data.repository.CategoryRepository;
import com.luisjrz96.blog.data.repository.PostRepository;
import com.luisjrz96.blog.data.repository.TagRepository;
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
}
