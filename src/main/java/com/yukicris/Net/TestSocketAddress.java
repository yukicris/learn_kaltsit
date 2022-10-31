package com.yukicris.Net;

import java.net.InetSocketAddress;

public class TestSocketAddress {


    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress  = new InetSocketAddress("localhost",8080);

        System.out.println(inetSocketAddress);
        System.out.println(socketAddress);

        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getHostName());//地址
        System.out.println(socketAddress.getPort());//端口
    }
}
