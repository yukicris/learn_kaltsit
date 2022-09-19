package com.yukicris.designModel.factory.abstract1;
//小米手机
public class XiaomiPhone implements IphoneProduct{
    @Override
    public void start() {
        System.out.printf("开启小米手机");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米手机");
    }

    @Override
    public void callup() {
        System.out.println("打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("发短信");
    }
}
