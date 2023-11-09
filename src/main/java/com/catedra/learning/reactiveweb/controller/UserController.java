package com.catedra.learning.reactiveweb.controller;

import com.catedra.learning.reactiveweb.dto.UserDto;
import com.catedra.learning.reactiveweb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public Mono<UserDto> create(@RequestBody @Valid Mono<UserDto> request) {
    return userService.create(request);
  }

  @GetMapping
  public Flux<UserDto> all() {
    return userService.getUsers();
  }
}
