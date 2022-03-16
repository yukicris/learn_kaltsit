package com.yukicris.Spring5.tst7.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


// 用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {



    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    //生成得到的代理类
    public Object getProxy(){
        // 这里三个参数为,类加载器,接口类加载,本对象
        return  Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }



    // 处理代理实例,并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seehouse();
        //动态代理的本质就是使用反射机制
        Object result = method.invoke(rent, args);
        fee();
        return result;
    }


    // 增加一些操作
    public void seehouse(){
        System.out.println("中介带看房子");
    }

    // 增加一些操作
    public void fee(){
        System.out.println("收取费用");
    }
}
