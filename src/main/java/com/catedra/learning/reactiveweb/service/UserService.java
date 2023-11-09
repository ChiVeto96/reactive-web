package com.catedra.learning.reactiveweb.service;

import com.catedra.learning.reactiveweb.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

  Mono<UserDto> create(Mono<UserDto> userDto);
  Flux<UserDto> getUsers();

  Mono<UserDto> findEmail(String email);


}
