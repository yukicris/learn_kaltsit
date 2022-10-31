package com.yukicris.Net.UDP_Chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveDemo02 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);

        //准备接受包裹


        while(true){
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data,0,data.length);
            socket.receive(packet);//阻塞式接受包裹

            //断开链接-bye
            byte[] datas = packet.getData();
            String str = new String(datas, 0, datas.length);
            System.out.println(str);
            if (str.equals("bye")){
                break;
            }
        }
        socket.close();

        




    }

}
