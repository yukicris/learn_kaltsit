package com.yukicris.designModel.factory.abstract1;

public class XiaomiRouter implements IRouteProduct{
    @Override
    public void start() {
        System.out.println("启动小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void openwifi() {
        System.out.println("打开小米路由器wifi");
    }

    @Override
    public void setting() {
        System.out.println("小米设置");
    }
}
