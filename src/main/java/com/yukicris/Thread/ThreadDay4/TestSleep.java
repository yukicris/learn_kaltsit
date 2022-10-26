package com.yukicris.Thread.ThreadDay4;

//模拟网络延时:放大问题的发生性
public class TestSleep implements Runnable{
    private int ticketNum = 10;


    @Override
    public void run() {
        while(true){
            if(ticketNum<=0){
                break;
            }
             try {
                 Thread.sleep(100);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNum--+"张票");
        }
    }


    public static void main(String[] args) {
        //此处就会出现多个线程同时操作同一个对象的线程不安全问题
        TestSleep ticket = new TestSleep();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();

       /* 黄牛拿到了第10张票
                小明拿到了第9张票
        老师拿到了第8张票
                黄牛拿到了第7张票
        老师拿到了第6张票
                小明拿到了第5张票
        黄牛拿到了第4张票
                老师拿到了第3张票
        小明拿到了第3张票
                黄牛拿到了第2张票
        小明拿到了第1张票
                老师拿到了第1张票
        黄牛拿到了第0张票*/


    }
}
