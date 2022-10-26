package com.yukicris.Thread.ThreadDay6;

public class TestYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }


}

class MyYield  implements Runnable{
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        //线程礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止执行");


        //礼让未成功
        /*a线程开始执行*/
        /*a线程停止执行*/
        /*b线程开始执行*/
        /*b线程停止执行*/
        //礼让成功
        /*a线程开始执行
        b线程开始执行
        a线程停止执行
        b线程停止执行*/
    }
}
