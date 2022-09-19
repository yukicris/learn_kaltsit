package com.yukicris.FaceTest;

public class Face8 {
    //这个就是认识下err类
    public static void main(String[] args) {
        //字符串常量池
        String str1 = "hello";
        String str2 = "he"+"llo";
        System.err.println(str1==str2);//true

        //声明了空间
        String str3 = "he"+new String("llo");
        System.err.println(str1==str3);//false

        //声明了空间
        String str4 = new String("hello");
        System.err.println(str1==str4);//false

    }


}
