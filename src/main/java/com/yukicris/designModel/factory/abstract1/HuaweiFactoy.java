package com.yukicris.designModel.factory.abstract1;

public class HuaweiFactoy implements IProductFactory{
    @Override
    public IphoneProduct iphoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public IRouteProduct irouteProduct() {
        return new HuaweiRouter();
    }
}
