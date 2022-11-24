package com.yukicris.collection1.Day3;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList_Source {
    //linkedList的增删改查案例
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
      /*
        1 无参构造
        public LinkedList() {
        }
        2 这个时候LinkedList的属性first = null last = null
        */


        linkedList.add(1);
       /* 3 装箱
       public static Integer valueOf(int i) {
            if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
                return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
            return new Integer(i);
        }*/
       /*4 执行添加
       public boolean add(E e) {
            linkLast(e);
            return true;
        }*/

      /* 5 将新的节点,加入到双向链表的最后
        void linkLast(E e) {  //第一次赋值,e就是我传的1
            final LinkedList.Node<E> l = last;  //null
            final LinkedList.Node<E> newNode = new LinkedList.Node<>(l, e, null);  null,1,null
            last = newNode;   //null,1,null
            if (l == null)
                first = newNode;   //null,1,null
            else
                l.next = newNode;
            size++;  //加一个大小
            modCount++;
        }*/
        // 6 再就差不多结束了

        // 然后再加一个元素
        linkedList.add(2);
        /*void linkLast(E e) {  //第一次赋值,e就是我传的1
            final LinkedList.Node<E> l = last;  //last现在是一个指针,就叫last
            final LinkedList.Node<E> newNode = new LinkedList.Node<>(l, e, null); // last,2,null
            last = newNode;   //last,2,null
            if (l == null)
                first = newNode;
            else
                l.next = newNode;  //last(pre),2,null
            size++;  //加一个大小
            modCount++; //修改了2次
        }*/

        // 再删除一个位置(有带坐标的和没带坐标的),默认删除是删除第一个
        linkedList.remove(2);
       /* public E remove(int index) {
            checkElementIndex(index); //判断是否是空链表
            return unlink(node(index));  //删除第N个节点
        }*/

      /*  E unlink(Node<E> x) {
            // assert x != null;
            final E element = x.item;
            final LinkedList.Node<E> next = x.next;
            final LinkedList.Node<E> prev = x.prev;

            if (prev == null) {  //第N个节点上一个为null,也就是删除第一个节点
                first = next;    //把头部直接指向下一个
            } else {             //不为第一个节点
                prev.next = next;  //上一个节点的next指向下一个节点(我删个2,类似于1指向3)
                x.prev = null;     //2的上一个节点置null
            }

            if (next == null) {    //如果第N个节点下一个节点为null,删最后
                last = prev;       //最后位指向上一个位置
            } else {
                next.prev = prev;     //下一个节点的上一位指向当前节点的上一位
                x.next = null;         //当前节点的下一位置空
            }

            x.item = null;             //当前节点元素置null  // help GC
            size--;                    //长度减少
            modCount++;                //更改次数++
            return element;
        }*/

        // 因为linkedList是实现了List接口,遍历方式可以是增强for循环和迭代器
        Iterator iterator = linkedList.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println("next="+next);
        }
        System.out.println("linkedList=" + linkedList);


    }

}
