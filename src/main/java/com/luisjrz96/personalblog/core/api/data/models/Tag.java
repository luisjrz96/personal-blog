package com.luisjrz96.personalblog.core.api.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
@Getter
@Setter
public class Tag  extends BaseModel {

    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "tag", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<PostTag> postTag = new HashSet<>();

}
