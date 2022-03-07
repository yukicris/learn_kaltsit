package com.yukicris.lambdaLearn;

import org.junit.Test;

public class Homework3 {
    // 声明一个带2个泛型的函数式接口,泛型类型为<T,R> T为参数,R为返回值
    //接口中声明对应的抽象方法
    // 在TestLambda类中声明方法,使用接口作为参数,计算两个long型参数的和
    //在计算两个long型参数的乘积

    public void yusuan(Long l1,Long l2, Homework3Child<Long,Long> hc) {
        System.out.println(hc.getValue(l1,l2));
    }


    @Test
    public void test3() {
        yusuan(100L,200L,(x,y)->x+y);
        yusuan(100L,200L,(x,y)->x*y);
    }
}
