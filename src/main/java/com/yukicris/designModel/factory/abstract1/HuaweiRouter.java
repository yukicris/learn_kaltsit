package com.yukicris.designModel.factory.abstract1;

public class HuaweiRouter implements IRouteProduct{
    @Override
    public void start() {
        System.out.println("启动华为路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为路由器");
    }

    @Override
    public void openwifi() {
        System.out.println("打开华为路由器wifi");
    }

    @Override
    public void setting() {
        System.out.println("华为设置");
    }
}
