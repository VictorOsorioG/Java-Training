package com.demo.rest.demoRest.service;

import com.demo.rest.demoRest.repository.UserRepository;
import com.demo.rest.demoRest.repository.model.User;
import com.demo.rest.demoRest.service.dto.UserDto;
import com.demo.rest.demoRest.service.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final String LOG_PREFIX = "Service -->";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {
        log.info("{} Se solicitaron todos los User", LOG_PREFIX);
        List<User> users = userRepository.selectAllUsers();
        log.info("{} Se mapean/transforman todos los User a UserDto", LOG_PREFIX);
        List<UserDto> userDtos = users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
        log.info("{} Se devuelven todos los User como UserDto", LOG_PREFIX);
        return userDtos;
    }

    @Override
    public UserDto getUser(UUID userUid) {
        log.info("{} Se solicito el usuarios con uid {}", LOG_PREFIX, userUid);
        Optional<User> userOptional = userRepository.selectUserByUid(userUid);
        log.info("{} Si se encontro el User se mapean/transforman a UserDto", LOG_PREFIX);
        UserDto userDto = userOptional
                .map(user -> modelMapper.map(user, UserDto.class))
                .orElseThrow();
        log.info("{} Se devuelve el User como UserDto", LOG_PREFIX);
        return userDto;
    }

    @Override
    public UserDto saveUser(UserRequest userRequest) {
        log.info("{} Se solicito guardar un UserRequest", LOG_PREFIX);
        log.info("{} Se crea el User con uid y otros datos", LOG_PREFIX);
        User userToSave = buildUserToSave(userRequest);
        log.info("{} Se solicita insertar el User con uid {}", LOG_PREFIX, userToSave.getUserUid());
        User userSaved = userRepository.insertUser(userToSave);
        log.info("{} Se mapean/transforman el User a UserDto", LOG_PREFIX);
        UserDto userDto = modelMapper.map(userSaved, UserDto.class);
        log.info("{} Se guardo el UserRequest y se devuelve como UserDto", LOG_PREFIX);
        return userDto;
    }

    private User buildUserToSave(UserRequest userRequest) {
        User userToSave = modelMapper.map(userRequest, User.class);
        UUID userUid = UUID.randomUUID();
        userToSave.setUserUid(userUid);
        return userToSave;
    }
}
