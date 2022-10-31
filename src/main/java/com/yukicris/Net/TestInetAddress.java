package com.yukicris.Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

//测试ip
public class TestInetAddress {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            System.out.printf("本机"+inetAddress);
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);


            //常用方法
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(inetAddress2.getAddress());
            System.out.println(inetAddress2.getCanonicalHostName());//规范名
            System.out.println(inetAddress2.getHostAddress());//ip
            System.out.println(inetAddress2.getHostName());//域名,或者自己电脑的名字
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
