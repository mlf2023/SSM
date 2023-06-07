package com.ztt.spring.test;

import com.ztt.spring.pojo.Clazz;
import com.ztt.spring.pojo.Person;
import com.ztt.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {
    @Test
    public void testIOC(){
        ApplicationContext ioc =new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        //Student student= (Student) ioc.getBean("studentOne");
        //Student student = ioc.getBean(Student.class);
        //Student student = ioc.getBean("studentOne", Student.class);
        Person person=ioc.getBean(Person.class);
        System.out.println(person);
    }
    @Test
    public void testDI(){
        ApplicationContext ioc =new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ioc.getBean("studentSix", Student.class);
        System.out.println(student);
    }
}
