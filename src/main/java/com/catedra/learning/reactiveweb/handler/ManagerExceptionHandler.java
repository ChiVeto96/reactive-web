package com.catedra.learning.reactiveweb.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.catedra.learning.reactiveweb.model.NotNullValuesDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ManagerExceptionHandler {

  @ExceptionHandler(WebExchangeBindException.class)
  public Mono<ResponseEntity<NotNullValuesDto>> methodArgumentNotValidException(WebExchangeBindException e) {

    NotNullValuesDto invalidData = new NotNullValuesDto();
    List<String> errors = new ArrayList<>();

    for (FieldError data : e.getBindingResult().getFieldErrors()) {
      errors.add(String.format("Invalid Field: %s, Cause: %s", data.getField(), data.getDefaultMessage()));
    }

    invalidData.setNumberOfInvalid(e.getBindingResult().getFieldErrorCount());
    invalidData.setValuesInvalid(errors);


    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidData));
  }

}
