package com.yukicris.Spring5.tst8.diy;


// 使用方式三,注解方式实现aop

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.swing.*;

@Aspect // 标注这个类是一个切面
public class AnnotationPointCut {
    // execution 的目的执行找到这个...类的所有方法,无论多少参数
    @Before("execution(* com.yukicris.Spring5.tst8.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.print("方法执行前===");
    }


    // 在环绕增强中,可以给定一个参数,代表我们需要获取处理切入的点
    @Around("execution(* com.yukicris.Spring5.tst8.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {

        System.out.println("环绕前");

        Signature signature = jp.getSignature();//获取类的签名
        System.out.println("打印签名"+ signature);
        //执行方法
        Object proceed = jp.proceed();
        System.out.println("环绕后");

    }
}
