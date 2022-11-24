package com.yukicris.collection1.Day1;

import java.util.ArrayList;

public class ArrayList_Kno {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("jack");
        arrayList.add(null);
        System.out.println(arrayList);
    }
/**
    //ArrayList底层是数组实现的
    // 基本等同于Vector,除了ArrayList线程不安全,多线程的情况下,不建议使用ArrayList
*/
    //这里没有加锁修饰
 /*   public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }*/

    /**
     * 结论
     * ArrayList中维护的是一个Object类型的数组elementData.[debug 看源码]
     * transient Object[] elemetData;   //transient 表示瞬间,短暂,表示这个属性不会被序列化
     *
     * 当创建ArrayList对象的时候,如果使用的是无参构造,则初始elementData的容量为0
     * 第一次添加扩容elementData为10,如果需要再次扩容,则扩容elementData为原来的1.5倍
     * 0->10>15>22>33
     *
     *
     * 如果使用的是指定大小的构造器,则初始elementData容量为指定大小,如果需要扩容,则直接扩容elementData为1.5倍
     *
     *
     * */
}
