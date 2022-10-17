package com.yukicris.JVM.java3;

import java.util.ArrayList;

public class day5 {
    byte[] array = new byte[1*1024*1024]; //1m

    public static void main(String[] args) {
        ArrayList<day5> list = new ArrayList<>();
        int count = 0;
        try{
            while(true){
                list.add(new day5());
                count = count +1;
            }
        }catch(Exception e){
            System.out.println("count"+count);
            e.printStackTrace();
        }
        //Throwable顶级
          //Exception
          //Error

    }

    //改完配置以后,返回
    //java.lang.OutOfMemoryError: Java heap space
    //Dumping heap to java_pid21212.hprof ...
    //Heap dump file created [984233363 bytes in 0.409 secs]
    //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    //	at com.yukicris.JVM.java3.day5.<init>(day5.java:6)
    //	at com.yukicris.JVM.java3.day5.main(day5.java:13)

    //然后去根目录,src同级目录找prof文件

    /**用软件打开,先看大对像,看是哪个对象出的问题,再看线程转储Thread Dump,
    哪个里面会有一个闪电,表示错误的,下面有错误的线程,以及行数见调试图
     记得清掉项目左边的分析文件，这里留着了，就是那个java——pid。。。。amalysis
然后举一反三,把后面的异常名字改一下就可以知道代码问题出在哪里了
     -Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
     //参数对应名称: -Xms:设置初始化内存分配大小,默认64分之一
      -Xms:最大分配内存,默认为四分之一
      -XX:+PrintGCDetail   //打印垃圾回收信息
     -XX:+HeapDumpOnOutOfMemoryError   //oom dump
     */

}
