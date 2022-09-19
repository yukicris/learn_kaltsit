package com.yukicris.designModel.factory.method;

public class WulinFactory  implements CarFactory{
    //工厂方法模式
    @Override
    public Car getCar() {
        return new Wulin();
    }
}
