package com.luisjrz96.personalblog.core.api.services.impl;

import com.luisjrz96.personalblog.core.api.data.models.QTag;
import com.luisjrz96.personalblog.core.api.data.models.Tag;
import com.luisjrz96.personalblog.core.api.data.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tagService")
public class TagService extends CrudServiceImpl<TagRepository, Tag, Integer, QTag> {


    @Autowired
    public TagService(TagRepository repository) {
        super(repository);
    }
}
