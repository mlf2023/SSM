package com.ztt.proxy;

import com.ztt.spring.proxy.Calculator;
import com.ztt.spring.proxy.CalculatorPureImpl;
import com.ztt.spring.proxy.CalculatorStaticProxy;
import com.ztt.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {
    /**
     * 动态代理有两种；
     * 1.jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口
     * 在com.sun.proxy包下，类名为$proxy2
     * 2.cglib动态代理，最终生成的代理类会继承目标类，并和目标类在相同包下
     */
    @Test
    public  void testProxy(){
        /*CalculatorStaticProxy proxy=new CalculatorStaticProxy(new CalculatorPureImpl());
        proxy.add(1,2);*/
        ProxyFactory proxyFactory=new ProxyFactory(new CalculatorPureImpl());
        Calculator proxy= (Calculator) proxyFactory.getProxy();
        proxy.div(1,1);
    }
}
