package com.yukicris.JVM.java1;

public class Demo1 {
    public static void main(String[] args) {
        new Thread(()->{

        },"my thread name").start();
    }

    // 凡是带了native关键字的,说明java的作用范围达不到了,可以去调用底层C语言库
    // 会进入本地方法栈
    //调用本地方法本地接口  JNI
    //JNI作用 : 扩展Java的使用,融合不同的编程语言为Java所用,最初C,C++
    //Java诞生的时候,C,C++横行,想要立足必须调用C++,C的程序
    //他在内存区域中专门开辟了一块标记区域,Native Method Stack,登记native方法
    // 在最终执行的时候,加载本地方法库中的方法通过Jni

    //Java程序驱动打印机,管理系统,掌握即可,在企业中较为少见
    private native void start0();

    //调用其他接口: Socket,WebService,Http

    //Native Method Stack
    //它的具体做法是Native Method Stack登记的native 方法,在Execution Engine 执行引擎执行的时候加载Native Libraies 本地库



}
