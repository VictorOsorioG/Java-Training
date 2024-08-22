package com.demo.rest.demoRest.controller;

import com.demo.rest.demoRest.service.UserService;
import com.demo.rest.demoRest.service.dto.UserDto;
import com.demo.rest.demoRest.service.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final String LOG_PREFIX = "Controller -->";

    private final UserService userService;

    @GetMapping
    public List<UserDto> fetchUsers() {
        log.info("{} Se solicitaron todos los User", LOG_PREFIX);
        List<UserDto> userDtos = userService.getAllUsers();
        log.info("{} Se devuelven todos los UserDto", LOG_PREFIX);
        return userDtos;
    }

    @GetMapping("/{userUid}")
    public UserDto fetchUser(@PathVariable UUID userUid) {
        log.info("{} Se solicito el User con uid {} proveniente del path", LOG_PREFIX, userUid);
        UserDto userDto = userService.getUser(userUid);
        log.info("{} Se devuelve el UserDto con uid {}", LOG_PREFIX, userUid);
        return userDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveNewUser(@RequestBody UserRequest userRequest) {
        log.info("{} Se solicito guardar el UserRequest proveniente del body", LOG_PREFIX);
        UserDto userDto = userService.saveUser(userRequest);
        log.info("{} Se devuelve el UserRequest guardado como UserDto", LOG_PREFIX);
        return userDto;
    }

}
