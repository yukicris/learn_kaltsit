package com.yukicris.Net.TCP_Chat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPdemo2Client {
    public static void main(String[] args) throws IOException {
        OutputStream os = null;
        Socket socket = null;
        try {

            //要知道服务器的地址,端口号
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            //2 端口
            int port = 9999;
            //3 创建一个socket链接
            socket = new Socket(serverIp,port);
            //4 发送消息 IO流
            os = socket.getOutputStream();
            os.write("欢迎学习".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(os!=null){
                os.close();
            }
            if(socket!=null){
                socket.close();
            }
        }
    }
}
