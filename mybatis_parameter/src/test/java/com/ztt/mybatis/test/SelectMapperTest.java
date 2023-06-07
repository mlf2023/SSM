package com.ztt.mybatis.test;

import com.ztt.mybatis.mapper.SelectMapper;
import com.ztt.mybatis.pojo.User;
import com.ztt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    @Test
    public void testGetUserById(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        SelectMapper mapper=session.getMapper(SelectMapper.class);
        User user=mapper.getUserById(1);
        System.out.println(user);
    }
    @Test
    public void testGetAllUser(){
        SqlSession session=SqlSessionUtil.getSqlSession();
        SelectMapper mapper=session.getMapper(SelectMapper.class);
        List<User> list=mapper.getAllUser();
        list.forEach(System.out::println);
    }
    @Test
    public void testGetAllCount(){
        SqlSession session=SqlSessionUtil.getSqlSession();
        SelectMapper mapper=session.getMapper(SelectMapper.class);
        int num=mapper.getCount();
        System.out.println(num);
    }

    @Test
    public void testGetUserByIdMap(){
        SqlSession session=SqlSessionUtil.getSqlSession();
        SelectMapper mapper=session.getMapper(SelectMapper.class);
        Map<String,Object> map= mapper.getUserByIdToMap(1);
        System.out.println(map);
    }
    @Test
    public void testGetAllUserMap(){
        SqlSession session=SqlSessionUtil.getSqlSession();
        SelectMapper mapper=session.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
    }
}
