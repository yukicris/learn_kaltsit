package com.yukicris.JVM.java3;

import java.util.Random;

public class day4 {
    //这里试图把堆内存配置调小,比如8兆
    public static void main(String[] args) {
        //模拟内存满了的场景
        String str = "asdasdasdas";
        while(true){
            str +=str+new Random().nextInt(888888888);
        }
    }

    //改成8兆堆内存以后,会走一堆gc然后走重gc,然后再重复,直到重gc也走不动了,就会报OOM  java.lang.OutOfMemoryError

    /**
     * 如果一个项目中出现了OOM故障,那么该如何排除,研究为什么会出错
     *   能够看到代码第几行出错,内存快照分析工具,MAT(Eclipse时代),Jprofiler
     *   Dubug,一行行分析代码!
     *
     * MAT,Jprofiler作用:
     * 分析Dump内存文件,快速定位内存泄漏;
     * 获得堆中的数据
     * 获得大的对象
     * ...
     *
     * 附12版本注册码: L-J12-STALKER#5846458-y8bdm6q8gtr7b#228a
     * L-J12-STALKER#8338547-qywh5933xu2r3#a4a4
     *
     * 安装本地版本,然后file-tool-jprofiler>选择安装目录下的bin里面的jprofiler.exe
     * 然后就好了
     */














    /*[GC (Allocation Failure) [PSYoungGen: 1536K->490K(2048K)] 1536K->829K(7680K), 0.0025687 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 2004K->495K(2048K)] 2344K->1085K(7680K), 0.0013383 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 1739K->488K(2048K)] 2329K->1429K(7680K), 0.0005773 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 1805K->488K(2048K)] 2746K->1748K(7680K), 0.0007152 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 1509K->488K(2048K)] 4048K->3042K(7680K), 0.0007244 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 1795K->504K(2048K)] 5628K->4983K(7680K), 0.0008337 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 504K->96K(2048K)] 4983K->5004K(7680K), 0.0005872 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [Full GC (Allocation Failure) [PSYoungGen: 96K->0K(2048K)] [ParOldGen: 4908K->2787K(5632K)] 5004K->2787K(7680K), [Metaspace: 3349K->3349K(1056768K)], 0.0074330 secs] [Times: user=0.02 sys=0.02, real=0.01 secs]
            [Full GC (Ergonomics) [PSYoungGen: 1338K->0K(2048K)] [ParOldGen: 5343K->2083K(5632K)] 6682K->2083K(7680K), [Metaspace: 3350K->3350K(1056768K)], 0.0047921 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 1308K->0K(2048K)] 5946K->4638K(7680K), 0.0002555 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4638K->4638K(7680K), 0.0002175 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4638K->4638K(5632K)] 4638K->4638K(7680K), [Metaspace: 3350K->3350K(1056768K)], 0.0057235 secs] [Times: user=0.06 sys=0.00, real=0.01 secs]
            [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4638K->4638K(7680K), 0.0002446 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4638K->4618K(5632K)] 4638K->4618K(7680K), [Metaspace: 3350K->3350K(1056768K)], 0.0057155 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
    Heap
    PSYoungGen      total 2048K, used 61K [0x00000000ffd80000, 0x0000000100000000, 0x0000000100000000)
    eden space 1536K, 4% used [0x00000000ffd80000,0x00000000ffd8f5d0,0x00000000fff00000)
    from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
    to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
    ParOldGen       total 5632K, used 4618K [0x00000000ff800000, 0x00000000ffd80000, 0x00000000ffd80000)
    object space 5632K, 82% used [0x00000000ff800000,0x00000000ffc82900,0x00000000ffd80000)
    Metaspace       used 3381K, capacity 4496K, committed 4864K, reserved 1056768K
    class space    used 370K, capacity 388K, committed 512K, reserved 1048576K
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    at java.util.Arrays.copyOf(Arrays.java:3332)
    at java.lang.AbstractStringBuilder.expandCapacity(AbstractStringBuilder.java:137)
    at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:121)
    at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:647)
    at java.lang.StringBuilder.append(StringBuilder.java:208)
    at com.yukicris.JVM.java3.day4.main(day4.java:11)*/
}
