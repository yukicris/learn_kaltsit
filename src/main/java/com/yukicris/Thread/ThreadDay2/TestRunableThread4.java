package com.yukicris.Thread.ThreadDay2;



//多个线程同时操作一个对象
//买火车票的例子
public class TestRunableThread4 implements Runnable{
    //票数
    private  int tickets = 10;

    @Override
    public void run() {
        while(true){
            //发现问题,多个线程操作同一个对象,会导致线程的紊乱,也就是并发重复问题,可以加个锁解决
            synchronized (this){
                //Thread.currentThread().getName()获取线程的名字
                if(tickets<=0){
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"拿到了第"+tickets--+"票");
            }


        }
    }

    public static void main(String[] args) {
        TestRunableThread4 t4 = new TestRunableThread4();
        new Thread(t4,"小明").start();
        new Thread(t4,"老师").start();
        new Thread(t4,"黄牛").start();
        //发现问题,多个线程操作同一个对象,会导致线程的紊乱,也就是并发重复问题,可以加个锁解决
    }
}
