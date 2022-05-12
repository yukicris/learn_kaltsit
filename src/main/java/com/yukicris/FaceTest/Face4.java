package com.yukicris.FaceTest;

public class Face4 {
    public static void main(String[] args) {
        // 有个这个包装类的问题
        Short a = 1;
        short b = 1;
        float c = 1;
        Float d = 1f;
        int e = 1;
        Integer f = 1;
        Double g = 1d;
        double h = 1;
    }


    // 事务有哪几种类型

    // 堆和栈
    //栈一般放内存地址  比如 arr1 = 0x11  堆放对象(0x01)->[1,2,3],数组也是对象,指针一般存放在栈空间,指向地址堆空间
    // 总结就是   堆中存放的是对象和数组。栈中存放的是基本数据类型和堆中对象的引用。
    // 栈 先进后出(链表也是先进后出,LinkList)   堆先进先出
    // 栈使用的是一级缓存， 他们通常都是被调用时处于存储空间中，调用完毕立即释放；
    // 堆是存放在二级缓存中，生命周期由虚拟机的垃圾回收算法来决定（并不是一旦成为孤儿对象就能被回收）。所以调用这些对象的速度要相对来得低一些。

    // 线程哪几种状态

    // linux 一些命令


    //http和rpc的区别

}
