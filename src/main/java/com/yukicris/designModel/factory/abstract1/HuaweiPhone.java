package com.yukicris.designModel.factory.abstract1;

//华为手机
public class HuaweiPhone implements IphoneProduct{
    @Override
    public void start() {
        System.out.printf("开启华为手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为手机");
    }

    @Override
    public void callup() {
        System.out.println("hw打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("hw发短信");
    }
}
