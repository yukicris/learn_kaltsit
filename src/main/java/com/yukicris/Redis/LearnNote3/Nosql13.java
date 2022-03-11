package com.yukicris.Redis.LearnNote3;

public class Nosql13 {
    // hyperloglog
    // 什么是基数

    /**
     * A {1,3,5,6,7,7}
     * B {1,3,5,7,8}
     *
     * 基数 (不重复的元素的个数 ) = 5 ,可以接受误差,一般做独立访客数
     *
     * Redis Hyperloglog 基数统计的算法
     *优点 占用的内存是固定的,2^64不同的元素的技术,只要12kb的内存,如果从内存角度来进行比较的话,Hyperlog是首选
     *
     *
     * 网页的UV (一个人访问一个网站多次,但是还是算作一个人)
     *
     * 传统的方式,set保存用户的id,然后就可以统计set中的元素数量作为标准判断
     * 这个方式如果保存大量用户的id ,会比较麻烦,目的是为了计数,而不是保存用户id(考虑内存占用)
     * 0.81%的错误率,统计Uv任务是可以忽略不计的
     *
     *
     */



    /**
     * PFadd mykey a b c d e f g h i j
     *
     * PFCOUNT mykey : 统计不重复的元素(基数)的数量
     * >10
     *
     * PFadd mykey2 i j z x c v b n m
     *
     * PFMERGE mykey3 mykey1 mykey2 去重合并到mykey3
     *
     * Pfcount mykey3
     * >15
     *
     * 如果允许容错,一定可以使用hyperloglog,如果不允许容错,就使用set或者自己的数据类型
     */

}
