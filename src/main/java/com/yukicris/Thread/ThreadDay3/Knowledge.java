package com.yukicris.Thread.ThreadDay3;

public class Knowledge {

    /**
     * 静态代理复习
     * //静态代理模式
     * //1 真实对象和代理对象都要实现同一个接口
     * //2 代理对象要代理真实角色,
     *
     * //好处: 代理对象可以做很多真实的对象做不了的事情,真实对象专注做自己的事情
     * new Thread(()-> System.out.println("我爱你")).start();
     */


    /**
     * Lambda表达式
     * 目的:简化开发
     *
     * //理解Function Interface(函数式接口)是学习Lambda表达式的关键所在
     *
     * 定义: 任何接口,如果只包含唯一的一个抽象方法,那么它就是一个函数式接口
     *      public Interface Runnable{
     *          public abstract void run();
     *      }
     *
     *      对于函数式接口,我们可以通过lambda表达式来创建该接口对象
     */
}
