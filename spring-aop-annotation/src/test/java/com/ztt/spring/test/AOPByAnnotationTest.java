package com.ztt.spring.test;

import com.ztt.spring.aop.annotation.Calculator;
import com.ztt.spring.aop.annotation.LoggerAspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPByAnnotationTest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(1,1);

    }
}
