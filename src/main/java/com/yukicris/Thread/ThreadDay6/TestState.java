package com.yukicris.Thread.ThreadDay6;


//观察测试线程的状态
public class TestState {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("/////");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state); //new状态

        //观察启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);   //run

        while(state!=Thread.State.TERMINATED){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState(); //更新线程状态
            System.out.println(state);
        }
        //thread.start(); //死亡以后的线程无法再次启动,所以这里会报异常
    }

 /*   NEW
    RUNNABLE
    TIMED_WAITING
    TIMED_WAITING
    TIMED_WAITING
    ...
    5s以后...
    /////
    TERMINATED*/
}
