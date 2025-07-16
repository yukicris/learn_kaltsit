package com.yukicris.Thread.ThreadDay1;

public class TestRunnable1 implements Runnable{
    // 实现runnable接口,重写run方法,执行线程需要丢入runable接口实现类,调用start方法
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("我在看代码"+i);
        }
    }


    public static void main(String[] args) {

        // 创建TestRunnable1类的实例，该类实现了Runnable接口，用于定义线程执行的任务
        TestRunnable1 testRunnable1 = new TestRunnable1();

        //创建线程对象,通过线程对象来开启线程,代理
       /* Thread thread = new Thread(testRunnable1);
        thread.start();*/

        new Thread(testRunnable1).start();


    }
}
