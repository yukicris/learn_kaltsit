package com.yukicris.Spring5.tst7.demo01;

public class Host implements Rent{
    // 房东类

    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}
