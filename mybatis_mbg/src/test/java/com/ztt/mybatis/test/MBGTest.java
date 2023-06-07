package com.ztt.mybatis.test;

import com.ztt.mybatis.mapper.EmpMapper;
import com.ztt.mybatis.pojo.Emp;
import com.ztt.mybatis.pojo.EmpExample;
import com.ztt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        EmpMapper mapper=session.getMapper(EmpMapper.class);
        //根据id查询数据
//        Emp emp = mapper.selectByPrimaryKey(1);
//        System.out.println(emp);
        //查询所有数据
//        List<Emp> emps = mapper.selectByExample(null);
//        emps.forEach(System   .out::println);
        //根据条件查询数据
//        EmpExample example = new EmpExample();
//        example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(18);
//        example.or().andGenderEqualTo("女");
//        List<Emp> emps = mapper.selectByExample(example);
//        emps.forEach(System.out::println);
        Emp emp=new Emp(1,"小红",null,"女");
        //测试普通修改功能
        /*mapper.updateByPrimaryKey(emp);*/
        //测试选择性修改功能
        mapper.updateByPrimaryKeySelective(emp);
    }

}
