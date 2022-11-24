package com.yukicris.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

//这边是终止操作符
public class java_stream2 {


    /**
     * 集合中是否有一个元素满足条件
     */
    public static void anyMatch(){
        List<String> strings = Arrays.asList("avc", "", "bc", "de", "ffsd");
        boolean b = strings.stream().anyMatch(s -> s.contains("b"));
        System.out.println(b);
    }

    /**
     * 集合中是否都满足条件
     */
    public static void allMatch(){
        List<String> strings = Arrays.asList("avc", "b", "bc", "de", "ffsd");
        boolean b = strings.stream().allMatch(s -> s.length()>0);
        System.out.println(b);
    }

    /**
     * 集合中所有元素都不满足条件
     */
    public static void noneMatch(){
        List<String> strings = Arrays.asList("avc", "b", "bc", "de", "ffsd");
        boolean b = strings.stream().noneMatch(s -> s.length()>5);
        System.out.println(b);
    }

    /**
     * 返回集合中任意元素
     */
    public static void findAny(){
        List<String> strings = Arrays.asList("avc", "b", "bc", "de", "ffsd");
        //返回值可能为空也坑你不为空,容器对象
        //这里是串行的,所以拿第一个最快,基本上都是拿第一个
        Optional<String> any = strings.stream().findAny();
        //如果要机会均等随机拿
        Optional<String> any1 = strings.parallelStream().findAny();
        //判断不为空
        if(any.isPresent()) System.out.println(any);
        if(any1.isPresent()) System.out.println(any1);
    }


    /**
     * 稳定拿第一个元素
     */
    public static void findFirst(){
        List<String> strings = Arrays.asList("avc", "b", "bc", "de", "ffsd");
        Optional<String> findFirst = strings.stream().findFirst();
        //判断不为空
        if(findFirst.isPresent()) System.out.println(findFirst);

    }


    /**
     * 循环
     */
    public static void foreach(){
        List<String> strings = Arrays.asList("avc", "b", "bc", "de", "ffsd");
        strings.stream().forEach(System.out::print);
    }



    /**
     * collect  将流转换成其他形式 list set map
     */
    public static void collect(){
        List<String> strings = Arrays.asList("avc", "avc", "bc", "de", "ffsd");
        Set<String> collect = strings.stream().collect(Collectors.toSet());
        //set无序且可以去重
        System.out.println(collect);

        //转map
        //这里让他自己做键,自己做值,如果重复的value就用新value
        Map<String, String> collect1 = strings.stream().collect(Collectors.toMap(v -> "yukicris_"+v, v -> v, (oldvalue, newvalue) -> newvalue));
        System.out.println("map"+collect1);
    }

    /**
     * 将集合中所有元素反复结合起来得到一个结果
     */
    public static void reduce(){
        List<String> strings = Arrays.asList("avc", "b", "bc", "de", "ffsd");
        //这里面需要传一个二进制方法, acc是初始值,item是里面的每个元素
        Optional<String> reduce = strings.stream().reduce((acc, item) -> {
            return acc + item;
        });
        if (reduce.isPresent()) System.out.println("reduce"+reduce.get());
    }


    /**
     * 返回集合元素个数
     */
    public static void count(){
        List<String> strings = Arrays.asList("avc", "b", "bc", "de", "ffsd");
        //这里面需要传一个二进制方法, acc是初始值,item是里面的每个元素
        long count = strings.stream().count();
        System.out.println("count"+count);
    }



    public static void main(String[] args) {
        anyMatch();

        allMatch();

        noneMatch();

        findAny();

        findFirst();

        foreach();

        collect();

        reduce();
    }

}
