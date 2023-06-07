package com.ztt.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }
    public Object getProxy(){
        /**
         * ClassLoader loader;指定加载动态生产成的代理类的类加载器
         * Class<?>[] interfaces;获取目标对象实现的所有接口class对象的数组
         * InvocationHandler h;
         */
        ClassLoader classLoader=this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object o= null;
                try {
                    System.out.println("[日志] "+method.getName()+" 方法开始了，参数是："+ Arrays.toString(args));
                    o = method.invoke(target,args);
                    System.out.println("[日志] "+method.getName()+" 方法结束了，参数是："+ Arrays.toString(args));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[日志] "+method.getName()+" 方法异常"+e);
                } finally {
                    System.out.println("[日志] "+method.getName()+" 方法执行完毕");
                }
                return o;
            }
        });
    }
}
