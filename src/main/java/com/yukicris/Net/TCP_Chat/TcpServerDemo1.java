package com.yukicris.Net.TCP_Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpServerDemo1 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            //1 知道服务器的地址
             serverSocket = new ServerSocket(9999);
            //等待客户端链接过来
             socket =serverSocket.accept();
            //读取客户端的消息
             inputStream = socket.getInputStream();
         /*   //比较老的方法
            byte[] buffer = new byte[1024]; //缓冲区
            int len;
            while((len=inputStream.read())!=-1){
                String msg = new String(buffer,0,len);
                System.out.printf(""+msg);
            }*/

            //管道流
             baos = new ByteArrayOutputStream();
             byte[] buffer = new byte[1024];
            int len;
            while((len=inputStream.read(buffer))!=-1){//消息不为空
                baos.write(buffer,0,len);
            }
            System.out.print("112313"+baos.toString());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }finally{
            //关闭资源,先开后关
            baos.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        }
    }
}
