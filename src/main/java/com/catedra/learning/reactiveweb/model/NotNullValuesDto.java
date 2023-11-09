package com.catedra.learning.reactiveweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotNullValuesDto {
  private Integer numberOfInvalid;
  private List<String> valuesInvalid;
}
