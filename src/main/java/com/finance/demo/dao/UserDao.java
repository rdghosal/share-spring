package com.finance.demo.dao;

import java.util.UUID;
import com.finance.demo.model.User;

public interface UserDao {

    boolean isExisting(User user);

    int insertUser(UUID id, User user);

    default int addUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

}