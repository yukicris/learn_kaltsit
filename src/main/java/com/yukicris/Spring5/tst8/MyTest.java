package com.yukicris.Spring5.tst8;

import com.yukicris.Spring5.tst8.service.UserService;
import com.yukicris.Spring5.tst8.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans8.xml");
        // 动态代理代理的是接口: 注意
        UserService userService =(UserService) context.getBean("userService");

        userService.add();
    }
}
