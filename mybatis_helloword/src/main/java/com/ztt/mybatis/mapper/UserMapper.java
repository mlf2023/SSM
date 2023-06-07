package com.ztt.mybatis.mapper;

import com.ztt.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    int insertUser();

    void updateUser();

    void deleteUser();

    List<User> getAllUser();

    User getUserById();
}
