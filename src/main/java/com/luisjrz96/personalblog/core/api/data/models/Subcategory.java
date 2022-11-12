package com.luisjrz96.personalblog.core.api.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subcategories")
@Getter
@Setter
public class Subcategory extends BaseModel{


    private String name;

    @JsonBackReference
    @JoinColumn(foreignKey = @ForeignKey(name = "fkSubcategories_category_id", foreignKeyDefinition = "FOREIGN KEY (category_id) references categories(id) ON DELETE SET NULL"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;


    @JsonBackReference
    @OneToMany(mappedBy = "subcategory", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<PostSubcategory> postSubcategory = new HashSet<>();

}
