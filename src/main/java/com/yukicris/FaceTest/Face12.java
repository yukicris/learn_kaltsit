package com.yukicris.FaceTest;

public class Face12 {
    // aop没有答好
    // spring security ,token相关

    /**
     *
     * 前端的加密逻辑
     * 登录,校验验证码,将密码进行加密,与加密好的密码进行比较
     * 2根据用户对象生成对应的token,同时设置过期时间
     * 3将生成的token再次加密
     * 4把用户的信息放入一个json中,并进行加密,然后将存放user的信息放入redis{key:token,value:jsonString}
     * 5将生成的token返回给前端,前端可以放入cookie,也可以存入localStorage
     */



    //线程池的使用
    //单条数据的事务

    //spring 的作用域

    //
    public static void main(String[] args) {
        String a = "asdcccsds";
        a = a.replace("c","m");
        int b = a.indexOf("m");//返回此字符第一次出现的索引
        int c = a.indexOf(1);//返回此字符第一次出现的索引
        int d = a.indexOf("s",4);//返回此字符从第四个字符开始第一次出现的索引
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
