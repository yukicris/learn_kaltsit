package com.yukicris.Spring5.tst6;

import com.yukicris.Spring5.tst6.config.Config;
import com.yukicris.Spring5.tst6.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

public class Test6 {
    public static void main(String[] args) {
        //AnnotationConfig 注解配置
        //如果完全使用配置类的方式来做,就只能通过AnnotationConfig上下文来获取容器,通过配置类class对象加载
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        User getUser = (User)context.getBean("getUser");
        System.out.println(getUser.getName());
    }
}
