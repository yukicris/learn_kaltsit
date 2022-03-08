package com.yukicris.designModel.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 懒汉式,想要用的时候才创建对象,比饿汉式节省内存
// 道高一尺魔高一丈
public class LazyMan {
    //步骤4
    private static boolean yukicris = false;

    //先构造器私有
    private LazyMan() {
        System.out.println(Thread.currentThread().getName()+"ok");
        //步骤3 给构造器私有加把锁,并且加个唯一标志位参数,表达它是第一次创建,不过这个参数依然可以被反射更改
        synchronized (LazyMan.class) {
            if (yukicris==false){
                yukicris = true;
            }else {
                throw new RuntimeException("不要视图使用反射破坏异常");
            }
//            if (lazyMan!=null){
//
//            }
        }
    }

    private volatile static LazyMan lazyMan;

    // 定义获取实例方法
    public static LazyMan getInstance(){
        //双重检测锁模式的懒汉式单例 简称dcl懒汉式
        if(lazyMan==null){
            //步骤2,给它上个锁包起来
            synchronized (LazyMan.class){
                if(lazyMan==null) {
                    lazyMan = new LazyMan(); //不是原子性操作
                    /**
                     * 1 分配内存空间
                     * 2 执行构造方法,初始化对象
                     * 3 把这个对象指向这个空间
                     *
                     * 123
                     * 132 A
                     *     B 此时lazyMan还没有完成构造
                     */
                }
            }
        }
        return lazyMan;
    }

    //单线程下可以,多线程下不行,会产生多个结果,不构成单例,所以要上锁,加步骤2,没有步骤1
   /* public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LazyMan.getInstance();
            }).start();
        }
    }*/

    // 反射可以破坏单例,所以可以再构造器里再加个锁,加步骤3
    public static void main(String[] args) throws Exception{
        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declare = LazyMan.class.getDeclaredConstructor(null);
        declare.setAccessible(true);
        LazyMan instance1 = declare.newInstance();
        LazyMan instance2 = declare.newInstance();

        System.out.println(instance);
        System.out.println(instance2);
    }

}
