package com.catedra.learning.reactiveweb.utils;

import com.catedra.learning.reactiveweb.dto.UserDto;
import com.catedra.learning.reactiveweb.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class Utility {
  public static UserDto entityToDto(UserEntity userEntity) {
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(userEntity, userDto);
    return userDto;
  }

  public static UserEntity dtoToEntity(UserDto userDto) {
    UserEntity userEntity = new UserEntity();
    BeanUtils.copyProperties(userDto, userEntity);
    return userEntity;
  }
}
