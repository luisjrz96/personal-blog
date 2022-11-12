package com.luisjrz96.personalblog.core.api.services.impl;

import com.luisjrz96.personalblog.core.api.data.models.Comment;
import com.luisjrz96.personalblog.core.api.data.models.QComment;
import com.luisjrz96.personalblog.core.api.data.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("commentService")
public class CommentService extends CrudServiceImpl<CommentRepository, Comment, Integer, QComment> {

    @Autowired
    public CommentService(CommentRepository repository) {
        super(repository);
    }
}
