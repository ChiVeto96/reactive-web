package com.catedra.learning.reactiveweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user")
public class UserEntity {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String email;
  private Long cellPhone;
  private boolean status;
}
