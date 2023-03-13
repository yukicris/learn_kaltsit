package com.yukicris.dataStructure.mianshibaodian;

import java.util.ArrayList;
import java.util.Arrays;

public class test3 {
    public static void main(String[] args) {
        //题1替换空格
        System.out.print(replaceSpace("We are happy."));
        //题2 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
        ListNode h = new ListNode(1);
        h.setNext(new ListNode(3));
        h.getNext().setNext(new ListNode(2));
        test3 t = new test3();
        System.out.println(t.reversePrint(h));
    }

    //题1
    public static String replaceSpace(String s) {
        //原生 raplaceall主要支持正则表达式
        return s.replace(" ","%20");

    }

    //题2
    ArrayList<Integer> arrayList = new ArrayList();
    public int[] reversePrint(ListNode head) {
        digui(head);
        int []list1 = new int[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            list1[i] = arrayList.get(i);
        }
        return list1;
    }


    public void digui(ListNode head){
        if (head==null){
            return;
        }
        digui(head.next);
        arrayList.add(head.val);
    }
}
