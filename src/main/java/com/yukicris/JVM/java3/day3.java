package com.yukicris.JVM.java3;

public class day3 {
    /**新生区*/
    // 类诞生,成长,死亡
    // 伊甸园,所有对象都是在伊甸园区new出来的
    // 幸存者(0,1)

    // 真理:经过研究,百分之99的对象都是临时对象

    /**永久区*/
    //这个区域常驻内存的,用来存放jdk自身的携带class对象,Interface元数据,存储的是Java运行时的一些环境或者类信息,
    //这个区域不存在垃圾回收!关闭JVM虚拟机就会释放这个区域的内存
    //一个启动类,加载了大量的第三方jar包,或者Tomcat部署了太多的应用,或者大量动态生产的反射类,不断的被加载,直到内存满,就会出现OOM;
     //jdk1.6之前 : 永久代,常量池在方法区中
     //jdk1.7 : 永久代,但是慢慢退化了,去永久代,常量池在堆中
     //jdk1.8: 无永久代,常量池在元空间
    /**
     * 面试就会问OOM的处理,
     * 1 把堆内存扩大看结果,(如果扩大了还有问题,那就是代码的问题,垃圾代码或者死循环)
     * 2 分析内存,看一下那个地方出现了问题(专业工具)
     */



    // 结合堆内部结构图理解一下,元空间(即以前的永久代),或者被称为非堆(虽然在堆里,但这一块有人认为不完全为堆),这一部分里面含有方法区,现在的常量池又放在了方法区里面,
    // 然后元空间区是线程共享的,供给伊甸园区去拿资源


    /**
     * 去改idea的设置选项 configuration-VM options -Xms1024m -Xmx1024m -XX:+PrintGCDetails
     * @param args
     */
    public static void main(String[] args) {
        //返回虚拟机试图使用的最大内存
        long max = Runtime.getRuntime().maxMemory(); //字节 1024*1024
        //返回jvm的总内存
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max="+max+"字节\t"+(max/(double)1024/1024)+"MB");
        System.out.println("total="+total+"字节\t"+(total/(double)1024/1024)+"MB");
        /*max=3804758016字节	3628.5MB   total=257425408字节	245.5MB*/

        //默认情况下,分配的总内存是电脑内存的1/4,初始化的内存是 1/64

        //改了设置选项以后,就会发现打印的东西变成了
       /* max=1029177344字节	981.5MB
                total=1029177344字节	981.5MB
                Heap
        PSYoungGen(新生代)      total 305664K, used 20971K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
         eden space 262144K, 8% used [0x00000000eab00000,0x00000000ebf7afb8,0x00000000fab00000)
         from space(幸存0区) 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
         to   space(幸存1区) 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
        ParOldGen(老年代)       total 699392K, used 0K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
         object space 699392K, 0% used [0x00000000c0000000,0x00000000c0000000,0x00000000eab00000)
        Metaspace(元空间)       used 3308K, capacity 4496K, committed 4864K, reserved 1056768K
         class space    used 360K, capacity 388K, committed 512K, reserved 1048576K*/

        //305664K+699392K=1005056k=981.5M  这部分没有算入元空间,所以元空间被称为逻辑上存在,但是物理上不存在,但是它属于堆
        //幸存0区和1区对应from to ,它们位置会互换
    }
}
