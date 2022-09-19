package com.yukicris.designModel.factory.simple;

public class Consumer {
    public static void main(String[] args) {
        //以前
        Car car = new Wulin();
        Car car1 = new Tesla();

        car.name();
        car1.name();
    }
}
