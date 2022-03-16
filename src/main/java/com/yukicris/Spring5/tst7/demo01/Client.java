package com.yukicris.Spring5.tst7.demo01;

import java.util.PrimitiveIterator;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        //host.rent();
        //代理,中介带房东租房子,但是代理角色一般会有一些附属操作
        Proxy proxy = new Proxy(host);
        //不用面对房东,直接找中介即可
        proxy.rent();
    }
}
