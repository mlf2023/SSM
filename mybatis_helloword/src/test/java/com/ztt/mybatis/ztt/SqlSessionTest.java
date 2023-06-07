package com.ztt.mybatis.ztt;

import com.ztt.mybatis.mapper.UserMapper;
import com.ztt.mybatis.pojo.User;
import com.ztt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SqlSessionTest {
    @Test
    public void testInsert() throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(is);
        SqlSession session=sqlSessionFactory.openSession(true);
        UserMapper mapper=session.getMapper(UserMapper.class);
        int result =mapper.insertUser();
//        session.commit();
        System.out.println(result);
        session.close();
    }
    @Test
    public void testUpdate(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        mapper.updateUser();;
        session.close();
    }
    @Test
    public void testDelete(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        mapper.deleteUser();
        session.close();
    }
    @Test
    public void testGetAllUser(){
        SqlSession session=SqlSessionUtil.getSqlSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        List<User> list=mapper.getAllUser();
        list.forEach(System.out::println);
    }
    @Test
    public void testGetUserById(){
        SqlSession session=SqlSessionUtil.getSqlSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user=mapper.getUserById();
        System.out.println(user);
    }
}
