package com.luisjrz96.personalblog.core.api.controllers.impl;

import com.luisjrz96.personalblog.core.api.data.models.Post;
import com.luisjrz96.personalblog.core.api.services.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController extends CrudControllerImpl<Post, Integer> {

    @Autowired
    public PostController(PostService postService) {
        super(postService);
    }

}
