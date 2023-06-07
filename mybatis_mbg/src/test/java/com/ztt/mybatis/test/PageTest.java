package com.ztt.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztt.mybatis.mapper.EmpMapper;
import com.ztt.mybatis.pojo.Emp;
import com.ztt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

public class PageTest {
    @Test
    public void testPage(){
        SqlSession session= SqlSessionUtil.getSqlSession();
        EmpMapper mapper=session.getMapper(EmpMapper.class);
        //查询功能之前开启分页功能
        Page<Object> page=PageHelper.startPage(2,4);
        List<Emp> emps = mapper.selectByExample(null);
        //查询功能之后可以获取分页相关的所有数据
        PageInfo<Emp> pageInfo =new PageInfo<>(emps,5);
        emps.forEach(System.out::println);
        System.out.println(pageInfo);
        /*PageInfo{pageNum=2,
         pageSize=4, size=1,
         startRow=5, endRow=5,
          total=5, pages=2,
          list=Page{count=true, pageNum=2, pageSize=4, startRow=4, endRow=8, total=5, pages=2, reasonable=false, pageSizeZero=false}
          [Emp{empId=7, empName='小丽', age=19, gender='女', deptId=2}],
           prePage=1,
           nextPage=0,
            isFirstPage=false,
            isLastPage=true,
           hasPreviousPage=true,
           hasNextPage=false,
           navigatePages=5,
           navigateFirstPage=1,
           navigateLastPage=2,
           navigatepageNums=[1, 2]}*/
        /*pageNum：当前页的页码
        pageSize：每页显示的条数
        size：当前页显示的真实条数
        total：总记录数
        pages：总页数
        prePage：上一页的页码
        nextPage：下一页的页码
        isFirstPage/isLastPage：是否为第一页/最后一页
        hasPreviousPage/hasNextPage：是否存在上一页/下一页
        navigatePages：导航分页的页码数
        navigatepageNums：导航分页的页码，[1,2,3,4,5]*/

    }

}
