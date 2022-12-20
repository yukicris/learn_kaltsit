package com.yukicris.collection1.Day3;

public class LinkedList_msg {
    // linkedList底层实现了双向链表和双端队列的特点
    // 可以添加任意元素(元素可以重复),包括null
    // 线程不安全,没有实现同步

    /**
     * LinkedList的底层结构
     *
     * 底层维护了一个双向链表
     * LinkedList中维护了两个属性,first和last,分别指向首节点和尾节点
     * 每个节点(Node对象)里面又维护了prev,next,item三个属性,其中通过prev指向前一个,通过next指向后一个节点,最终实现双向链表
     * 所以 LinkedList的元素添加和删除,不是通过数组完成的,相对来说效率更高效
     * 模拟一个简单的双向链表
     *
     *
     */
}
