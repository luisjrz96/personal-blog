package com.luisjrz96.blog.data.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "users")
public class User extends BaseModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Long userId;

  private String email;

  private String username;

  private String password;

}
