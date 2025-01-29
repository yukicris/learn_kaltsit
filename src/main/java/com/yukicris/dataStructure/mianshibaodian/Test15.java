package com.yukicris.dataStructure.mianshibaodian;

public class Test15 {
    //现在是对应第18题
    //给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
    //
    //返回删除后的链表的头节点。
    //示例 1:
    //
    //输入: head = [4,5,1,9], val = 5
    //输出: [4,1,9]
    //解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
    //示例 2:
    //
    //输入: head = [4,5,1,9], val = 1
    //输出: [4,5,9]
    //解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
    // 
    //
    //说明：
    //
    //题目保证链表中节点的值互不相同
    //若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点


    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val) return head.next;  //第一个相等,直接返回下一个链表[4,5,1,9]去掉4,即[5,1,9]
        ListNode now = head;
        ListNode nextNode = head.next;
        while(nextNode!=null&&nextNode.val!=val){
            now = nextNode;                  //保存前置位,[4,5,1,9]去掉1,即当now=[5]的时候,nextNode=[1]跳出循环
            nextNode = nextNode.next;
        }
        if(nextNode!=null) now.next = nextNode.next;  //然后把[5].next = [1].next 链接起来即可
        return head;
    }

}
