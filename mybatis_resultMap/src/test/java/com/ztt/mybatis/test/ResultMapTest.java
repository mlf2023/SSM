package com.ztt.mybatis.test;

import com.ztt.mybatis.mapper.DeptMapper;
import com.ztt.mybatis.mapper.EmpMapper;
import com.ztt.mybatis.pojo.Dept;
import com.ztt.mybatis.pojo.Emp;
import com.ztt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ResultMapTest {
    @Test
    public void testGetEmpByEmpId(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        EmpMapper mapper=session.getMapper(EmpMapper.class);
        Emp emp=mapper.getEmpByEmpId(1);
        System.out.println(emp);
    }
    @Test
    public void testGetEmpAndDeptByEmpId(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        EmpMapper mapper=session.getMapper(EmpMapper.class);
        Emp emp=mapper.getEmpAndDeptByEmpId(1);
        System.out.println(emp);
    }
    @Test
    public void testGetEmpAndDeptByStep() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(emp.getEmpName());
    }
    @Test
    public void testGetDeptAndEmpByDeptId() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        DeptMapper mapper=session.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(dept);
    }
    @Test
    public void testGetDeptAndEmpByStepOne() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        DeptMapper mapper=session.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
    }
}
