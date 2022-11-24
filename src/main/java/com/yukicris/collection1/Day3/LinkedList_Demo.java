package com.yukicris.collection1.Day3;

public class LinkedList_Demo {
    // 模拟一个简单的双向链表
    public static void main(String[] args) {
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node cris = new Node("cris");

        //链接三个节点,形成双向链表
        jack.next = tom;
        tom.next = cris;
        cris.pre = tom;
        tom.pre = jack;
        Node first = jack; //让fitst
        Node last = cris;

        // 从头到尾进行遍历
        while(true) {
            if (first==null){
                break;
            }
            //输出first信息
            System.out.println(first);
            first = first.next;
        }

        // 从尾到头遍历
        while(true) {
            if (last==null){
                break;
            }
            //输出first信息
            System.out.println(last);
            last = last.pre;
        }

        //添加一个对象
        // 在tom和cris 中间插入一个对象,yukis
        // 创建一个Node节点
        Node yukis = new Node("Yukis");
        tom.next = yukis;
        yukis.pre = tom;
        yukis.next = cris;
        cris.pre = yukis;
        // 遍历查看结果
        // 让first 再次指向第一个人
        first = jack;
        while(true) {
            if (first==null){
                break;
            }
            //输出first信息
            System.out.println(first);
            first = first.next;
        }

    }

}


// 定义一个Node类,node对象表示双向链表的一个节点
class Node{
    public Object item;  //真正存放数据的地方
    public Node next;  //指向下一个节点
    public Node pre;   //指向上一个节点

    public Node(Object name) {
        this.item = name;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node name: " + item;
    }
}