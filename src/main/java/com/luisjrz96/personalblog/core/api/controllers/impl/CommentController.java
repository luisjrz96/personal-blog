package com.luisjrz96.personalblog.core.api.controllers.impl;

import com.luisjrz96.personalblog.core.api.data.models.Comment;
import com.luisjrz96.personalblog.core.api.services.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/comments")
public class CommentController extends CrudControllerImpl<Comment, Integer>{

    @Autowired
    public CommentController(CommentService commentService) {
        super(commentService);
    }
}
