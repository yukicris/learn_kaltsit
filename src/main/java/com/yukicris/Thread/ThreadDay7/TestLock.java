package com.yukicris.Thread.ThreadDay7;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    //显式定义同步锁
    /**
     * juc.locks.Lock 接口是控制多个线程对共享资源进行访问的工具
     * 锁提供了对共享资源的独占访问,每次只能有一个线程对Lock对象加锁
     * 线程开始访问共享资源之前应当先获得Lock对象
     *
     * ReentrantLock(可重入锁) 类实现Lock,它拥有与synchronized 相同的并发性和内存语义
     * 在实现线程安全的控制中,比较常用的是ReentrantLock 可以显式加锁,释放锁
     */

    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        //此处不加lock.三个资源同时请求一个对象,很不安全
    }


}


class TestLock2 implements Runnable{
    int ticketNums = 1000;
    // 加锁,定义一个Lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            try{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock(); //加锁
                if (ticketNums>0) {
                    System.out.println(ticketNums--);
                } else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }

        }
    }
}
