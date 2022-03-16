package com.yukicris.Spring5.tst8.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Log implements MethodBeforeAdvice {

    // method  要执行目标对象的方法
    // args: 参数
    //targer: 目标对象
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+ "的"+method.getName()+ "被执行了");
    }
}
