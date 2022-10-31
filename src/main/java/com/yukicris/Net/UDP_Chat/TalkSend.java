package com.yukicris.Net.UDP_Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{
    //发送方的多线程改造版本

    DatagramSocket socket = null;
    BufferedReader reader = null;

    private int fromPort;
    private String toIp;
    private int toPort;

    public TalkSend(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toIp = toIp;
        this.toPort = toPort;
        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        //DatagramSocket socket = new DatagramSocket(8888);
        //准备数据,从控制台读取system.in
        while(true){
            try {
                    String data = reader.readLine();//读取那一行的消息
                    byte[] datas = data.getBytes();
                    DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIp,this.toPort));
                    socket.send(packet);
                    if(data.equals("bye")){
                        break;
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
