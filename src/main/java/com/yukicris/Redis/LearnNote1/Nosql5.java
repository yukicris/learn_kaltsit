package com.yukicris.Redis.LearnNote1;

public class Nosql5 {
    /**
     * 基础知识
     */


    /**
     * redis 默认有16 个数据库,默认使用的是第0个
     * 可以使用select进行切换,不同数据库拿到不同的值
     * keys * 查看当前数据库所有key
     * dbsize 查看数据库大小
     * flushdb 清空当前数据库
     * flushall 清除全部数据库内容
     *
     * 为什么是6379(他粉的明星的名字打在手机上...)
     *
     * redis是单线程的,基于内存操作,cpu不是它的性能瓶颈,Redis的瓶颈是基于机器的内存和网络带宽,
     * 可以使用单线程就用单线程了
     *
     * Redis是C语言写的,官方提供的数据为 100000+qps(每秒查询数),完全不比同样使用key-value的memecache差
     *
     *
     * Redis为什么单线程还这么快?
     * 1 误区1 高性能服务器一定有多线程的?
     * 2 误区2 多线程(CPU上下文切换) 一定比单线程效率高
     * 去cpu>内存>硬盘速度有所了解
     *  核心: redis是将所有数据放在内存中,所以说使用单线程去操作效率就是最高的,多线程(CPU上下文会切换,会耗时)
     *  对于内存系统来说,没有上下文切换效率就是最高的,多次读写都是在一个cpu上的,在内存情况下这个就是最佳方案
     *



     [root@VM-0-6-centos bin]# redis-cli
     127.0.0.1:6379> select 3
     (error) NOAUTH Authentication required.
     127.0.0.1:6379> auth flzx3000c
     OK
     127.0.0.1:6379> select 3
     OK
     127.0.0.1:6379[3]> dbsize
     (integer) 0
     127.0.0.1:6379[3]> get name
     (nil)
     127.0.0.1:6379[3]> select 0
     OK
     127.0.0.1:6379> get name
     "yukicris"
     127.0.0.1:6379> dbsize
     (integer) 1
     127.0.0.1:6379> keys *
     1) "name"
     127.0.0.1:6379> flushdb
     OK
     127.0.0.1:6379> keys *
     (empty array)
     127.0.0.1:6379>


     */
}
