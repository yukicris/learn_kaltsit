package com.yukicris.Thread.ThreadDay6;

public class TestPriority{
    //测试线程优先级   优先级高的不一定先跑
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
        //
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);


        //先设置优先级再启动
        t1.start();


        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY); // 最大优先级10
        t4.start();


        t5.setPriority(8);
        t5.start();

        t6.setPriority(7);
        t6.start();

      /*  t5.setPriority(-1);
        t5.start();

        t6.setPriority(11);
        t6.start();
        //-1和11这种超了1~10的一般会报异常
        */

        /*main-->5
        Thread-0-->5
        Thread-3-->10
        Thread-2-->4
        Thread-1-->1*/

    }
}

class MyPriority implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}
