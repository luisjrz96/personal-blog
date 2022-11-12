package com.luisjrz96.personalblog.core.api.data.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post extends BaseModel{

    private String title;
    private String content;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<PostSubcategory> postSubcategory = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<PostTag> postTag = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

}
