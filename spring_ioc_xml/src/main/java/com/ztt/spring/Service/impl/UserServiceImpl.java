package com.ztt.spring.Service.impl;


import com.ztt.spring.Service.UserService;
import com.ztt.spring.dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
