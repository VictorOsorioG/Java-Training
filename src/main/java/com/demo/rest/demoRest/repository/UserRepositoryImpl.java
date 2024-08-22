package com.demo.rest.demoRest.repository;

import com.demo.rest.demoRest.repository.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final String LOG_PREFIX = "Repository -->";

    private final Map<UUID, User> users = new HashMap<>();

    public UserRepositoryImpl() {
        UUID joeUid = UUID.fromString("bbcc4621-d88f-4a94-ae2f-b38072bf5081");
        UUID janeUid = UUID.fromString("bbcc4621-d88f-4a94-ae2f-b38072bf5082");
        users.put(joeUid,
                User.builder()
                        .name("Joe Smith")
                        .age(20)
                        .userUid(joeUid)
                        .createdAt(LocalDate.now())
                        .sensitiveInformation("TOP SECRET")
                        .build()
        );
        users.put(janeUid,
                User.builder()
                        .name("Jane Smith")
                        .age(20)
                        .userUid(janeUid)
                        .createdAt(LocalDate.now())
                        .sensitiveInformation("TOP SECRET")
                        .build());
    }

    @Override
    public List<User> selectAllUsers() {
        log.info("{} Se solicitaron todos los User", LOG_PREFIX);
        List<User> userList = users.values().stream().toList();
        log.info("{} Se devuelven todos los User", LOG_PREFIX);
        return userList;
    }

    @Override
    public Optional<User> selectUserByUid(UUID userUid) {
        log.info("{} Se solicito el User con uid {}", LOG_PREFIX, userUid);
        Optional<User> user = Optional.ofNullable(users.get(userUid));
        log.info("{} Se devuelve el User con uid {}", LOG_PREFIX, userUid);
        return user;
    }

    @Override
    public User insertUser(User user) {
        UUID userUid = user.getUserUid();
        log.info("{} Se solicito agregar un nuevo User con uid {}", LOG_PREFIX, userUid);
        users.put(userUid, user);
        User userInserted = users.get(userUid);
        log.info("{} Se inserto el User con uid {} y se devuelve", LOG_PREFIX, userUid);

        return userInserted;
    }
}
