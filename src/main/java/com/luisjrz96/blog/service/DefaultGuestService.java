package com.luisjrz96.blog.service;

import com.luisjrz96.blog.data.dto.PostDto;
import com.luisjrz96.blog.data.mapper.PostDtoMapper;
import com.luisjrz96.blog.data.mapper.RestPageMapper;
import com.luisjrz96.blog.data.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultGuestService implements GuestService {

  private final PostRepository postRepository;
  private final PostDtoMapper postDtoMapper;
  private final RestPageMapper restPageMapper;

  @Override
  public Page<PostDto> getAllPosts(Pageable pageable) {
    return postRepository.findAll(pageable)
          .map(postDtoMapper::toPostDto);
  }
}
