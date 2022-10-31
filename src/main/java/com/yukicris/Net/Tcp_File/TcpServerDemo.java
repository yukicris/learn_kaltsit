package com.yukicris.Net.Tcp_File;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo {
    public static void main(String[] args) throws IOException {
        //1 创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2 监听客户端的链接
        Socket socket = serverSocket.accept();//阻塞式监听,会一直等待客户端的链接
        //3 获取输入流
        InputStream inputStream = socket.getInputStream();
        //4 文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));
        byte [] buffer= new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len); //赋值从0到len
        }
        //通知客户端我接受完毕了
        OutputStream os = socket.getOutputStream();
        os.write("我接受完毕了,你可以断开了".getBytes());



        // 关闭资源
        fos.close();
        inputStream.close();
        serverSocket.close();

    }
}
