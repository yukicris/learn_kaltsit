package com.yukicris.Net.UDP_Chat;

public class TalkStudent {
    public static void main(String[] args) {
        //开启2个线程,打开TalkStudent和TalkTeacher实现在控制台的老师和学生聊天功能

        //静态代理runnable接口
        new Thread(new TalkSend(7777,"localhost",9999)).start();
        new Thread(new TalkReceive(8888)).start();
    }
}
