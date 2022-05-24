package com.yukicris.Thread.ThreadDay1;

public class TestThread extends Thread{
    //1 继承Thread类

    @Override
    public void run() {
        //重写run方法
        for (int i=0;i<20;i++){
            System.out.println("我在看代码");
        }
    }


    public static void main(String[] args) {


        // 创建一个线程对象,然后执行它的start方法
        TestThread testThread = new TestThread();
        testThread.start();  //只有start才是启动线程


        // 主线程
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程"+i);
        }
        //此时主线程和线程是一起执行的,由cpu来调度顺序,不是start以后就立即执行

    }
}
