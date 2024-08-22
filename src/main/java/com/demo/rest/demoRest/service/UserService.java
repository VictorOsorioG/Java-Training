package com.demo.rest.demoRest.service;

import com.demo.rest.demoRest.service.dto.UserDto;
import com.demo.rest.demoRest.service.dto.UserRequest;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUser(UUID userUid);
    UserDto saveUser(UserRequest user);
}

