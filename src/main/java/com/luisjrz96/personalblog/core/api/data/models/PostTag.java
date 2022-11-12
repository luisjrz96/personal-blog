package com.luisjrz96.personalblog.core.api.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts_tags")
@Getter
@Setter
public class PostTag extends BaseModel{

    @JsonBackReference
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fkPosts_Tags_post_id", foreignKeyDefinition = "FOREIGN KEY (post_id) references posts(id) ON DELETE SET NULL"))
    Post post;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fkPosts_Tags_tag_id", foreignKeyDefinition = "FOREIGN KEY (tag_id) references tags(id) ON DELETE SET NULL"))
    Tag tag;

}
