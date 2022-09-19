package com.yukicris.designModel.factory.method;

public class Consumer {
    public static void main(String[] args) {
        Car car = new WulinFactory().getCar();

        car.name();
    }
}
