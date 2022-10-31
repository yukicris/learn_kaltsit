package com.yukicris.Net.Tcp_File;

import com.yukicris.FaceTest.B;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建一个socker
        Socket socket  = new Socket(InetAddress.getByName("127.0.0.1"),9000);
        // 2 创建一个输出流
        OutputStream outputStream = socket.getOutputStream();

        // 3 文件流,读取文件
        FileInputStream fis = new FileInputStream(new File("1.jpg"));
        //4 写出文件
        byte[] buffer = new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }

        //通知服务器我已经结束了
        socket.shutdownOutput(); //我已经传输完了

        // 确定服务器接受完毕,才能断开链接
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while((len2=is.read(buffer2))!=-1){
            baos.write(buffer,0,len2);
        }
        System.out.println(baos.toString());



        // 关闭资源
        baos.close();
        is.close();
        fis.close();
        outputStream.close();
        socket.close();
    }

}
