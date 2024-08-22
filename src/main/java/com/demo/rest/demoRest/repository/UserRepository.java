package com.demo.rest.demoRest.repository;

import com.demo.rest.demoRest.repository.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    List<User> selectAllUsers();
    Optional<User> selectUserByUid(UUID userUid);
    User insertUser(User user);
}
