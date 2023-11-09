package com.catedra.learning.reactiveweb.controller;

import com.catedra.learning.reactiveweb.dto.UserDto;
import com.catedra.learning.reactiveweb.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

public class UserControllerTest {
  @InjectMocks
  private UserController userController;

  @Mock
  private UserService userService;

  private WebTestClient webTestClient;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    webTestClient = WebTestClient.bindToController(userController).build();
  }

  @Test
  public void testCreateUser() {
    UserDto userDto = new UserDto();
    userDto.setFirstName("John");
    userDto.setLastName("Doe");
    userDto.setEmail("john.doe@example.com");
    userDto.setCellPhone(1234567890L);
    userDto.setStatus(true);

    Mono<UserDto> userDtoMono = Mono.just(userDto);

    Mockito.when(userService.create(userDtoMono)).thenReturn(userDtoMono);

    webTestClient
            .post()
            .uri("/api/user")
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromValue(userDto))
            .exchange()
            .expectStatus().isOk()
            .expectBody(UserDto.class);
  }

  @Test
  public void testGetAllUsers() {
    UserDto user1 = new UserDto();
    user1.setFirstName("John");
    user1.setLastName("Doe");
    user1.setEmail("john.doe@example.com");
    user1.setCellPhone(1234567890L);
    user1.setStatus(true);

    UserDto user2 = new UserDto();
    user2.setFirstName("Jane");
    user2.setLastName("Smith");
    user2.setEmail("jane.smith@example.com");
    user2.setCellPhone(9876543210L);
    user2.setStatus(true);

    Flux<UserDto> users = Flux.just(user1, user2);

    Mockito.when(userService.getUsers()).thenReturn(users);

    webTestClient
            .get()
            .uri("/api/user")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(UserDto.class)
            .hasSize(2)
            .contains(user1, user2);
  }

}
