package com.ztt.mybatis.mapper;

import com.ztt.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 获取全部用户信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 获取用户信息条数
     * @return
     */
    Integer getCount();

    /**
     * 根据id查询用户信息为Map集合
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所以用户信息为一个map集合
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
}
