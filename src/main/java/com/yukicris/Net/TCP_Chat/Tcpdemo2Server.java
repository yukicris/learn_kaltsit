package com.yukicris.Net.TCP_Chat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Tcpdemo2Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            //1 知道服务器的地址
            serverSocket = new ServerSocket(9000);

            while(true){
                socket =serverSocket.accept();
                //读取客户端的消息
                inputStream = socket.getInputStream();

                //管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while((len=inputStream.read(buffer))!=-1){//消息不为空
                    baos.write(buffer,0,len);
                }
                System.out.print(""+baos.toString());
            }



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
