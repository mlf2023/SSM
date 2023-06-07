package com.ztt.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.security.SignatureSpi;
import java.util.Arrays;

@Component
@Aspect//将当前组件标识为切面
public class LoggerAspect {
    @Pointcut("execution(* com.ztt.spring.aop.annotation.CalculatorPureImpl.*(..))")
    public void pointCut(){

    }
    //@Before("execution(public int com.ztt.spring.aop.annotation.CalculatorPureImpl.add(int,int))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点对应方法签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，方法："+signature.getName()+",参数"+ Arrays.toString(args));
    }
    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，方法："+signature.getName()+",执行完毕");
    }
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法" +signature.getName()+",结果："+result);
    }
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint ,Exception e){
        Signature signature=joinPoint.getSignature();
        System.out.println("LoggerAspect,方法" +signature.getName()+",异常:"+e);
    }
    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("1");
            result = joinPoint.proceed();
            System.out.println("2");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("3");
        }finally {
            System.out.println("4");
        }
        return result;
    }
}
