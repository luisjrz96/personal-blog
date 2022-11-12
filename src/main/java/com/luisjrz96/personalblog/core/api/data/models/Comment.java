package com.luisjrz96.personalblog.core.api.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment extends BaseModel{

    private String content;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "fkComments_post_id", foreignKeyDefinition = "FOREIGN KEY (post_id) references posts(id) ON DELETE SET NULL"))
    private Post post;

}
