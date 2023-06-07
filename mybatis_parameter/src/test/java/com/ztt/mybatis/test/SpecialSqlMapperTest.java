package com.ztt.mybatis.test;

import com.ztt.mybatis.mapper.SpecialSqlMapper;
import com.ztt.mybatis.pojo.User;
import com.ztt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSqlMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper=session.getMapper(SpecialSqlMapper.class);
        List<User> list =mapper.getUserByLike("a");
        list.forEach(System.out::println);
    }
    @Test
    public void testDeleteMoreUser(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper=session.getMapper(SpecialSqlMapper.class);
       mapper.deleteMoreUser("1,4");
    }
    @Test
    public void testGetUserList(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper=session.getMapper(SpecialSqlMapper.class);
        List<User> userList = mapper.getUserList("t_user");
        userList.forEach(System.out::println);
    }
    @Test
    public void testInsertUser(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper=session.getMapper(SpecialSqlMapper.class);
        User user=new User(null,"小明","123456",12,"男","123456@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
