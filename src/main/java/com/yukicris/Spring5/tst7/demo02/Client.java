package com.yukicris.Spring5.tst7.demo02;



import com.yukicris.Spring5.tst7.demo02.UserserviceImpl;

public class Client {
    public static void main(String[] args) {
        UserserviceImpl userService = new UserserviceImpl();
        //userService.add();
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserservice(userService); //这句别漏了,用set方式进行代理
        userServiceProxy.add();      //用代理模式增加了一个日志功能
    }
}
