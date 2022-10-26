package com.yukicris.Thread.ThreadDay4;


//测试stop
//1 建议线程正常停止-->利用次数,不建议死循环
//2 建议使用标志位-->设置一个标志位
//3 不要使用stop,destorty等过时或者jdk不建议使用的方法
public class Teststop implements Runnable{

    //1 设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            //标志位被转换,跳出循环,执行内容直接结束
            System.out.println("run...Thread"+i++);
        }
        System.out.println("测试"+i++);
    }

    //2 设置一个公开的方法停止线程,转换标志位
    public void stop(){
        this.flag = false;
    }


    public static void main(String[] args) {
        Teststop teststop = new Teststop();
        new Thread(teststop).start();
        for (int i=0;i<1000;i++){
            System.out.println("main"+i);
            if (i==900){
                //调用stop方法,切换标志位让子线程停止
                teststop.stop();
                System.out.println("停止该线程");
            }
        }
    }
}
