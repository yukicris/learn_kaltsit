package com.yukicris.Net.UDP_Demo;


import java.net.*;

//不需要链接服务器
public class UDP_ClientDemo {

    public static void main(String[] args) throws Exception {

        //1 建立一个socket(数据报)
        DatagramSocket socket = new DatagramSocket();
        //2 建个包
        String msg = "你好,服务器";
        //3 发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
        //4 发送包
        socket.send(packet);
        //5 关闭流
        socket.close();

    }
}
