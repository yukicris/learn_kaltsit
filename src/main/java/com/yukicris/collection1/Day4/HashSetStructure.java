package com.yukicris.collection1.Day4;

public class HashSetStructure {
    //hashSet简单结构 数组+链表约等于hashMap
    public static void main(String[] args) {
        // 模拟一个hashMap的底层

        //1 创建一个数组,数组的类型是Node[]
        //2 有些人直接把Node[] 数组称之为表(table)
        Node[] table = new Node[16];
        System.out.println("table="+table);
        //3 创建节点
        Node john = new Node("john", null);
        table[2] = john;
        System.out.println("table="+table);

        Node jack = new Node("jack", null);
        john.next = jack;
        Node rose = new Node("rose",null);
        jack.next = rose;
        System.out.println("table="+table);

        Node lucy = new Node("lucy", null);
        table[3] = lucy;

    }


}


class Node{
    //结点,存储数据,可以指向下一个结点,从而形成链表
    Object item; //存放数据
    Node next;   //指向下一个结点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}