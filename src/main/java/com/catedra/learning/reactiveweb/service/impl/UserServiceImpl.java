package com.catedra.learning.reactiveweb.service.impl;

import com.catedra.learning.reactiveweb.dto.UserDto;
import com.catedra.learning.reactiveweb.repository.UserRepository;
import com.catedra.learning.reactiveweb.service.UserService;
import com.catedra.learning.reactiveweb.utils.Utility;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Flux<UserDto> getUsers() {
    return userRepository.findAllByStatusIsTrue().map(Utility::entityToDto);
  }

  @Override
  public Mono<UserDto> create(Mono<UserDto> userDto) {
    return userDto.map(Utility::dtoToEntity)
            .flatMap(userRepository::insert)
            .map(Utility::entityToDto);
  }
}
