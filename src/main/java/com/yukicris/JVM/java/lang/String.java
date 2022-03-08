package com.yukicris.JVM.java.lang;

public class String {
    // 双亲委派机制: 安全
    // 1 .APP-EXT(额外加载器)-BOOT(最终执行,为根加载器)
    // boot里面没有的话,就会去ext里面找


    public java.lang.String toString() {
        return "toString";
    }

    public static void main(String[] args) {
        // 此时无法通过编译,或者报错,说未能找到main方法
        String s = new String();// 此处的String点进去虽然是本String类,但是会根据双亲委派机制找到跟加载器下的Strin类
        s.toString();
    }
}
