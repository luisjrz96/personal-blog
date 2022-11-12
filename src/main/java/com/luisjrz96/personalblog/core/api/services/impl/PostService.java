package com.luisjrz96.personalblog.core.api.services.impl;

import com.luisjrz96.personalblog.core.api.data.models.Post;
import com.luisjrz96.personalblog.core.api.data.models.QPost;
import com.luisjrz96.personalblog.core.api.data.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("postService")
public class PostService extends CrudServiceImpl<PostRepository, Post, Integer, QPost>{

    @Autowired
    public PostService(PostRepository repository) {
        super(repository);
    }
}
