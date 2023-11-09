package com.catedra.learning.reactiveweb.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  @NotNull
  @Length(min = 5,max = 30)
  private String firstName;
  @NotNull
  @Length(min = 5,max = 30)
  private String lastName;
  @Email
  @NotNull
  @Length(min = 5,max = 50)
  private String email;
  @NotNull
  private Long cellPhone;
  private boolean status;
}
