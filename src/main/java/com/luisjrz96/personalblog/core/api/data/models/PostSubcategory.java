package com.luisjrz96.personalblog.core.api.data.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "posts_subcategories")
@Getter
@Setter
public class PostSubcategory extends BaseModel {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fkPosts_Subcategories_post_id", foreignKeyDefinition = "FOREIGN KEY (post_id) references posts(id) ON DELETE SET NULL"))
    Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "fkPosts_Subcategories_subcategory_id", foreignKeyDefinition = "FOREIGN KEY (subcategory_id) references subcategories(id) ON DELETE SET NULL"))
    Subcategory subcategory;

}
