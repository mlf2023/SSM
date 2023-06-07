package com.ztt.mybatis;

import com.ztt.mybatis.mapper.DynamicSqlMapper;
import com.ztt.mybatis.pojo.Emp;
import com.ztt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper=session.getMapper(DynamicSqlMapper.class);
        Emp emp=new Emp(null,"张三",35,"") ;
        List<Emp> emps = mapper.getEmpByChoose(emp);
        emps.forEach(System.out::println);
    }
    @Test
    public void testInsertMoreEmp(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper=session.getMapper(DynamicSqlMapper.class);
        Emp emp=new Emp(null,"小明",18,"男") ;
        Emp emp1=new Emp(null,"小红",17,"女") ;
        Emp emp2=new Emp(null,"小丽",19,"女") ;
        List<Emp> emps1 = Arrays.asList(emp, emp1, emp2);
        mapper.insertMoreEmp(emps1);
    }
    @Test
    public void testDeleteMoreEmp(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        DynamicSqlMapper mapper=session.getMapper(DynamicSqlMapper.class);
        Integer[] empIds=new Integer[]{5,6};
        mapper.getEmpByChoose(new Emp());
    }
}
