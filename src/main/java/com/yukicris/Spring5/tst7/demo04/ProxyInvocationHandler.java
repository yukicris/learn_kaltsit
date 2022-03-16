package com.yukicris.Spring5.tst7.demo04;

import com.yukicris.Spring5.tst7.demo3.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


// 用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {



    //被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //生成得到的代理类
    public Object getProxy(){
        // 这里三个参数为,类加载器,接口类加载,本对象
        return  Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    // 处理代理实例,并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 通过反射机制得到method
        log(method.getName());


        //动态代理的本质就是使用反射机制
        Object result = method.invoke(target, args);
        return result;
    }


    public void log(String msg){
        System.out.println("执行了"+ msg+ "方法");
    }


}
