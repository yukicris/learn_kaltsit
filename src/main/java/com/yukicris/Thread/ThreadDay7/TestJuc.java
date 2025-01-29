package com.yukicris.Thread.ThreadDay7;

import java.util.concurrent.CopyOnWriteArrayList;

// 测试juc 安全类型集合
public class TestJuc {
    public static void main(String[] args) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            }).start();
        }
        //不加这个延时有可能导致主线程比Thread先执行完,打印不够10000
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(copyOnWriteArrayList.size());
    }
}
