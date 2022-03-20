package com.yukicris.JVM.java1;

public class Demo1 {
    public static void main(String[] args) {
        new Thread(()->{

        },"my thread name").start();
    }

    // 凡是带了native关键字的,说明java的作用范围达不到了,可以去调用底层C语言库
    // 会进入本地方法栈 
    private native void start0();
}
