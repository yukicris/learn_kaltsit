package com.yukicris.FaceTest;

public class Face6 {
    //先执行父类的静态方法，再执行子类的静态方法，然后再父类的构造方法，最后是子类的构造方法。
    //父亲比儿子先执行,静态方法永远最先执行
    /**
     *
     public class A {

     static{
     System.out.print(1);
     }
     public A(){
     System.out.print(2);
     }
     }

     public class B extends A{

     static{
     System.out.print("a");
     }
     public B(){
     System.out.print("b");
     }
     }

     public class C {

     public static void main(String[] args){
     A a = new B();
     a = new B();
     }
     }



     得到1a2b2b
     */

    public static void main(String[] args) {
       /*
       B b = new B();
        b = new B();
        //得到1a2b2b
        */

        /*
        A a = new B();
        a = new B();
        //1a2b2b
         */

        /*A a = new B();
        a = new B();
        A a1 = new A();*/
        //1a2b2b2

        A a1 = new A();
        A a = new B();
        a = new B();
        //12a2b2b
    }






    //JVM配置
 /*   常见配置汇总
            堆设置
-Xms:初始堆大小
-Xmx:最大堆大小
-XX:NewSize=n:设置年轻代大小
-XX:NewRatio=n:设置年轻代和年老代的比值。如:为3，表示年轻代与年老代比值为1：3，年轻代占整个年轻代年老代和的1/4
            -XX:SurvivorRatio=n:年轻代中Eden区与两个Survivor区的比值。注意Survivor区有两个。如：3，表示Eden：Survivor=3：2，一个Survivor区占整个年轻代的1/5
            -XX:MaxPermSize=n:设置持久代大小
            收集器设置
-XX:+UseSerialGC:设置串行收集器
-XX:+UseParallelGC:设置并行收集器
-XX:+UseParalledlOldGC:设置并行年老代收集器
-XX:+UseConcMarkSweepGC:设置并发收集器
            垃圾回收统计信息
-XX:+PrintGC
-XX:+PrintGCDetails
-XX:+PrintGCTimeStamps
-Xloggc:filename
            并行收集器设置
-XX:ParallelGCThreads=n:设置并行收集器收集时使用的CPU数。并行收集线程数。
            -XX:MaxGCPauseMillis=n:设置并行收集最大暂停时间
-XX:GCTimeRatio=n:设置垃圾回收时间占程序运行时间的百分比。公式为1/(1+n)
    并发收集器设置
-XX:+CMSIncrementalMode:设置为增量模式。适用于单CPU情况。
            -XX:ParallelGCThreads=n:设置并发收集器年轻代收集方式为并行收集时，使用的CPU数。并行收集线程数。*/
}
