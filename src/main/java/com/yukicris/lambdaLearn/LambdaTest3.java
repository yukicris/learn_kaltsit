package com.yukicris.lambdaLearn;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest3 {
    // 实际应用场景下,常用的内置函数式接口
    // Consumer<T> : 消费型接口    void accept(T t);

    // Supplier<T> : 供给型接口     T get();

    // Function<T,R> : 函数型接口    R apply(T t);

    // predicate<T> : 断言型接口    boolean test(T t);


    /**
     * Consumer<T> 消费型接口: 没有返回值,跑了就跑了
     */

    @Test
    public void test1() {
        happy(10000,m-> System.out.println("消费完了"+ m+ "元"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    /**
     * Supplier<T> 供给型接口
     * 需求,产生一些数,并放入集合中
     */
    @Test
    public void test2() {
       List<Integer> numList = getNumList(10,()->(int)(Math.random()*100));

       for (Integer num: numList) {
           System.out.println(num);
       }
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<num;i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return  list;
    }


    /**
     * Function<T.R> 函数型接口
     *
     * 需求,用于处理字符串
     */
    public String strHandler(String str, Function<String,String> fun) {
        return fun.apply(str);
    }

    @Test
    public void test3() {
        String str1 = strHandler("lisi",str->str.toUpperCase());
        System.out.println(str1);
    }

    /**
     * predicate<T> 断言型接口:
     * 需求: 将满足条件的字符串放入集合中去
     *
     */

    public List<String> filterStr (List<String> list , Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str: list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;

    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("hello","yukicirsia","Lambda","222","ok");
        List<String> strList = filterStr(list,(s)->s.length()>3);

        for(String str : strList) {
            System.out.println(str);
        }
    }
}
