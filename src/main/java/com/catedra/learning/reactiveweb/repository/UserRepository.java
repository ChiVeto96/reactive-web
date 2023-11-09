package com.catedra.learning.reactiveweb.repository;

import com.catedra.learning.reactiveweb.entity.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserEntity,String> {

  Flux<UserEntity> findAllByStatusIsTrue();
  Mono<UserEntity> findByEmail(String email);
}
