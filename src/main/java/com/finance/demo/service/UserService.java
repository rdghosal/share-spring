package com.finance.demo.service;

import com.finance.demo.dao.UserDao;
import com.finance.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("mssql") UserDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }
}