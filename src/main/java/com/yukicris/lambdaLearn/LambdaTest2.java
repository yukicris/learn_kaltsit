package com.yukicris.lambdaLearn;

import org.junit.Test;

public class LambdaTest2 {

    //实际使用
    // 需求: 对一个数进行运算
    @Test
    public  void test1() {
        Integer num  = operation(100, (x) -> x*x);
        System.out.println(num);
        System.out.println(operation(100,y->++y));

    }


    public Integer operation(Integer num,MyFunction mf){
        return mf.getValue(num);
    }
}
