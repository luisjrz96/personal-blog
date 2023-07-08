package com.luisjrz96.blog.data.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Generated
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subcategories")
public class Subcategory extends BaseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "subcategory_id")
  private Long subcategoryId;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;
}
