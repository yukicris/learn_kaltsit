package com.yukicris.Spring5.tst7.demo04;


import com.yukicris.Spring5.tst7.demo02.UserService;
import com.yukicris.Spring5.tst7.demo02.UserserviceImpl;

import java.lang.reflect.InvocationHandler;

public class Client {

    public static void main(String[] args) {
        // 真实角色
        UserserviceImpl userService = new UserserviceImpl();

        //代理角色,创建
        ProxyInvocationHandler phi = new ProxyInvocationHandler();

        //设置要代理的对象
        phi.setTarget(userService);
        //动态生成代理类
        UserService proxy =  (UserService)phi.getProxy();

        proxy.del();

    }
}
