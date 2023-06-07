package com.ztt.mybatis.test;

import com.ztt.mybatis.mapper.UserMapper;
import com.ztt.mybatis.pojo.User;
import com.ztt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class ParameterTest {
    @Test
    public void testGetUserByUsername(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user=mapper.getUserByUsername("root");
        System.out.println(user);
    }
    @Test
    public void testCheckLogin(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user=mapper.checkLogin("root","123");
        System.out.println(user);
    }
    @Test
    public void testCheckLoginByMap(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","root");
        map.put("password","123");
        User user=mapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        mapper.insertUser(new User(null,"root","123456",33,"女","123456@qq.com"));
    }
    @Test
    public void testCheckLoginByParam(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user=mapper.checkLoginByParam("root","123");
        System.out.println(user);
    }
}
