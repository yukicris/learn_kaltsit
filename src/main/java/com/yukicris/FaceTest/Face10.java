package com.yukicris.FaceTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Face10 {
    //苏州科大国创
    //tmd一个外包问这么多..

    //线程安全的集合
    //Vector、HashTable、Stack、ArrayBlockingQueue、ConcurrentHashMap、ConcurrentLinkedQueue
    
    //数组转list,list转数组
    public static void main(String[] args) {
        /**
         * 数组转list
         */
        //1 用集合的方法,

        String[] strArray = {"1","2","3"};
        ArrayList< String> arrayList = new ArrayList<String>(strArray.length);
        Collections.addAll(arrayList, strArray);
        arrayList.add("1");
        System.out.println(arrayList);

        //2 用ArrayList自带的构造器
        List<String> list2 = Arrays.asList(strArray);
        System.out.println(list2);

        /**
         * list转数组
         */

        Object[] objects = arrayList.toArray();
        System.out.println(objects[1]);

        //指定String类型
        String[] strings = arrayList.toArray(new String[arrayList.size()]);
        System.out.println(strings[1]);

    }
    //aop

    //注入方式哪几种
    //redis数据类型 位图的使用..真tm有人问这个啊
    //springboot自动装配相关,代码是怎么写的
    //rabbitmq 死信队列,消息订阅模式
    //网络编程:这是啥
    //mybatis用过哪些插件.这玩意有插件??
    //常用设计模式哪些
    //线程:线程池
    //数据库索引相关建立

    //tmd照着文档问老子是吧

    //什么是抽象,什么事抽象接口

    //索引命中率怎么查看,数据查询效率怎么查看

    //map遍历

    //缓存雪崩

}
