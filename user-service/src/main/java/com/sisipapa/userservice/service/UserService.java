package com.sisipapa.userservice.service;

import com.sisipapa.userservice.dto.UserDto;
import com.sisipapa.userservice.jpa.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
