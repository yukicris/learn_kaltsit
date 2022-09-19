package com.yukicris.designModel.factory.abstract1;

public class Client {
    public static void main(String[] args) {
        System.out.println("小米---");
        //小米工厂
        XiaomiFactoy xiaomiFactoy = new XiaomiFactoy();
        IRouteProduct iRouteProduct = xiaomiFactoy.irouteProduct();
        iRouteProduct.openwifi();
        iRouteProduct.setting();
    }
}
