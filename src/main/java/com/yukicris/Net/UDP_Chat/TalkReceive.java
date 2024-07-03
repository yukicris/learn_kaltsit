package com.yukicris.Net.UDP_Chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
    DatagramSocket socket =null;
    private int port;

    public TalkReceive(int port) {
        this.port = port;

        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){
            try { // 异常放在循环外面,如果出现异常就会停止循环,放在里面,更有针对性,但是如果异常多了可能会爆内存

                    byte[] data = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(data,0,data.length);
                    socket.receive(packet);//阻塞式接受包裹

                    //断开链接-bye+
                    byte[] datas = packet.getData();
                    String str = new String(datas, 0, datas.length);
                    System.out.println("接收到:"+str);
                    if (str.equals("bye")){
                        break;
                    }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
