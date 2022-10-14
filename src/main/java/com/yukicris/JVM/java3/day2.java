package com.yukicris.JVM.java3;

import java.util.Random;

public class day2 {
    // 三种JVM
    // sun公司, HOTPOT 我们都是用的这个
    // BEA JRockit
    // IBM j9vm


    //堆 HEAP 一个JVM只有一个堆,(ps.栈是线程级的线程私有的) 堆内存的大小是可以调节的

    // 类加载器读取了类文件以后,一般会把什么东西放到堆中: 类的实例,方法,常量(1.8常量池不在方法区了),变量
    //堆里的是方法引用，常量池分为静态常量池和运行时常量池，方法区里的是静态常量池，堆里的是运行时常量池

    // 堆内存中细分为三个区域
    /**
     *  1 新生区 eden
     *  2 老年代
     *  3 永久代(1.8没有永久代了,叫做元空间)
     *
     *
     *  新生区: 1 Eden Space(创建) 2 幸存区0区 3 幸存区1区  ,在gc过后还没有被干掉会进入幸存区
     *  轻gc,是关于新生区的,重gc(fULL GC)是关于老年区的
     *
     *  GC垃圾回收主要是在伊甸园区和养老区
     *  假设内存满了,OOM,堆内存不够
     */

    public static void main(String[] args) {
        //模拟内存满了的场景
        String str = "asdasdasdas";
        while(true){
            str +=str+new Random().nextInt(888888888);
        }
    }
    //str可以无限加,但是内存不行这里会报OutOfMemoryError: Java heap space

    // JDK8以后,永久存储区改了个名字,叫做元空间
}
