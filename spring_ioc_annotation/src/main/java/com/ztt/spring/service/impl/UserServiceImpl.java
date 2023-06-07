package com.ztt.spring.service.impl;

import com.ztt.spring.dao.UserDao;
import com.ztt.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void saceUser() {
        userDao.saveUser();
    }
}
