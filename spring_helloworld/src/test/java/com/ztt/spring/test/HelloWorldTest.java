package com.ztt.spring.test;

import com.ztt.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void test(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorld = (HelloWorld) ioc.getBean("HelloWorld");
        helloWorld.sayHello();
    }
}
