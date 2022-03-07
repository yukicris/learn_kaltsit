package com.yukicris.lambdaLearn;

import org.junit.Test;

public class Homework2 {
    // 声明函数式接口,接口中声明抽象方法,public String getValue(String str);
    // 声明类TestLambda, 类中编写方法使用接口作为参数,将一个字符串转换成大写,并作为方法的返回值
    // 再将一个字符串的第二个和第四个索引位置截取子串
    @Test
    public void TestLambda(){
        System.out.printf(""+strHandler("zhangsan",str->str.toUpperCase()));

        strHandler("zhagnsan", str->str.substring(2,5));
    }

    public String strHandler(String str,Homework2Child hc) {
        return  hc.getValue(str);
    }
}
