package com.yukicris.Net.UDP_Demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDP_ServerDemo {

    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //接受数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);//阻塞接受

        //byte转string 用构造函数转换
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        //关闭链接
        socket.close();

    }
}
