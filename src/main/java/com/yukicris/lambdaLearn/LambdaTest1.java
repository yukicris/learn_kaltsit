package com.yukicris.lambdaLearn;


// java8 引入了"->"操作符
// 将lambda表达式拆分成2部分

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 *  一定需要"函数式接口"的支持
 *  函数式接口: 接口中只有一个抽象方法时,这个方法就是函数式接口. 可以使用注解@FunctionalInterface修饰一下
 *  可以检查是否为函数式接口
 *
 *  左侧: lambda表达式的参数列表
 *  右侧: 表达式中所需要执行的功能,即lambda体
 *
 *  语法格式1 : 无参数且无返回值
 *  () -> system.out.println("Hello Lambda");
 *
 *
 *  语法格式2 : 一个参数,无返回值
 *
 *
 *
 *  语法格式3: 若只有一个参数,小括号可以省略不写
 *
 *
 *  语法格式4: 有2个以上参数,且lambda中有多条语句,只能用大括号
 *
 *  语句格式5: 若lambda 体中只有一条语句,则大括号和return都可以不写
 *
 *
 *  语法格式6: lambda表达式的参数列表数据类型可以省略不写,因为jvm编译器可以通过上下文推断数据类型,即"类型推断"
 *
 *  左右遇1括号省,左侧推断类型省
 */


public class LambdaTest1 {
    int num = 0; // jdk1.7以前默认加了final,现在依然默认加了,不过可以省略

    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world"+ num++);
            }
        };
        r.run();

        System.out.printf("--------------");

        Runnable r1 = () -> System.out.println("hello world2");
        r1.run();
    }


    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(""+x);
        con.accept("打印成功");
    }

    @Test
    public void test3() {
        Consumer<String> con = x -> System.out.println(""+x);
        con.accept("打印成功");
    }


    @Test
    public void test4() {
        Comparator<Integer> com = (x,y) -> {
            System.out.printf("函数式接口");
            return Integer.compare(x,y);
        };
    }

    @Test
    public void test5() {
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
    }


    @Test
    public void test6() {
        Comparator<Integer> com = (Integer x,Integer y) -> Integer.compare(x,y);
    }
}
