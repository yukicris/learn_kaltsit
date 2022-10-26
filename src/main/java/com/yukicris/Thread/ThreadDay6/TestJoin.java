package com.yukicris.Thread.ThreadDay6;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        try {
            //加个sleep看得更明显,以免cpu调度它交替执行,去掉sleep就会有可能交替执行
            //也就是说一开始可能会是并发,但是一旦插队了,就一定会让插队的先执行完再执行其他的
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了"+i);

        }
    }


    public static void main(String[] args) throws InterruptedException {
        TestJoin join = new TestJoin();
        //这里其实是一种静态代理模式
        Thread thread=new Thread(join);
        thread.start();

        //主线程
        for (int i = 0; i < 1000; i++) {
            if(i==200){

                thread.join();//插队
            }
            System.out.println("main"+i);
        }
    }
}
