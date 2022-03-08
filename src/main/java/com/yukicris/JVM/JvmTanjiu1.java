package com.yukicris.JVM;

// jvm探究1
public class JvmTanjiu1 {
    /**
     * 谈谈对jvm的理解,java8虚拟机和之前的变化更新
     * 什么是oom ,什么是栈溢出StackOverFlowError? 怎么分析?
     * JVM常用调优参数有哪些
     * 内存快照如何抓取,怎么分析Dump文件
     * jvm类加载器的认识
     *
     */

    /**
     * jvm的位置: {
     *     首先在操作系统(Windows,Linux,Mac)上,本质也是一个软件(环境JRE-JVM)
     *     硬件体系(Intel,Spac)
     * }
     * jvm的体系结构: {
     *     .java->calss File ->
     *     类装载器class Loader ->
     *     运行时数据区(Runtime Data AREA,runtime异常也是这里出现):->{
     *         方法区 method
     *         java 栈 stack    无垃圾,栈用完即弹了,所以不会有垃圾
     *         本地方法栈  Native Method Stack   无垃圾
     *         程序计数器 Counter   无垃圾
     *          堆    Heap  99%的gc是在堆中
     *     }<-> {
     *           本地方法接口 <-本地方法库
     *           执行引擎
     *     }
     *
     * }
     * 类加载器
     *
     *
     * 双亲委派机制
     * 沙箱安全机制
     * Native
     * PC寄存器
     * 方法区
     * 栈
     * 三种jvm
     * 新生区,老年区
     * 永久区(8以后叫做元空间)
     * 堆内存调优
     * GC
     *      1.常用算法
     * JMM
     * 总结
     */



}
