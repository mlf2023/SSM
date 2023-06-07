package com.ztt.spring.controller;

import com.ztt.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller("controller")
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saceUser();
    }
}
