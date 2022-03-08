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
     *
     *
     * jvm的体系结构: {
     *     .java->calss File ->
     *     类装载器class Loader ->
     *     运行时数据区(Runtime Data AREA,runtime异常也是这里出现):->{
     *         方法区 method
     *         java 栈 stack    无垃圾,栈用完即弹了,所以不会有垃圾
     *         本地方法栈  Native Method Stack   无垃圾 (native修饰的方法为C++等语言原生代码实现的,所以叫本地方法)
     *         程序计数器 Counter   无垃圾
     *          堆    Heap  99%的gc是在堆中
     *     }<-> {
     *           本地方法接口 <-本地方法库
     *           执行引擎
     *     }
     *
     * }
     *
     *
     *
     * 类加载器{
     *     作用:加载class文件(~) new Student();这个student的引用(名字,地址 student1:01xxx)在栈里面,这个对象在堆里面
     *     Car.class -> ClassLoader ->加载初始化为 Car Class (类) ->实例化(new) -> car1,car2,...
     *     把实例化对象变成class-> getClassLoader
     *
     *     1. 虚拟机自带的加载器 ()
     *     2 启动类(根) 加载器 (Boot)
     *     3 扩展类加载器 (Ext)
     *     4 应用程序加载器 (App)
     *     此处参考java包中的String类和Student类中的详细解释
     *
     *     1.类加载器收到类加载的请求
     *     2.讲这个请求向上委托给父类加载器中完成,一直向上委托,直到启动类加载器
     *     3. 启动加载器检查是否能够加载当前这个类,能加载就结束,使用当前加载器,否则抛出异常,通知子类加载器进行加载
     * }
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
