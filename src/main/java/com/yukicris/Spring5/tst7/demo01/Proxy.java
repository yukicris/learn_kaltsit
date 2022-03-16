package com.yukicris.Spring5.tst7.demo01;

// 代理
public class Proxy {
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    public Proxy() {
    }


    public void rent () {
        seehouse();
        host.rent();
        fee();
    }


    // 看房
    public void seehouse () {
        System.out.println("中介带你看房");
    }

    // 收取费用
    public void fee () {
        System.out.println("中介收取费用");
    }
}
