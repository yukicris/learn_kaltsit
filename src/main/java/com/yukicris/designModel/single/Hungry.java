package com.yukicris.designModel.single;


// 饿汉式单例
public class Hungry {

    // 单例模式必须有私有构造方法
    private Hungry(){

    }

    // 保证它是唯一的
    private final static Hungry HUNGRY = new Hungry();

    //抛出给外界引用
    public static  Hungry getInstance() {
        return HUNGRY;
    }

}
