package com.yukicris.designModel.factory.abstract1;

public class XiaomiFactoy implements IProductFactory{
    @Override
    public IphoneProduct iphoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public IRouteProduct irouteProduct() {
        return new XiaomiRouter();
    }
}
