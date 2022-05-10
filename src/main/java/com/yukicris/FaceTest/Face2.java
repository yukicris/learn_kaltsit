package com.yukicris.FaceTest;

public class Face2 {
    /**京迈 问的基础比较多,比较深刻的一个问题是  list如何取出第一个值的*/



    /*
    线性表使用顺序（数组）存储时有个弊端，那就是在插入和删除时需要大量的移动数据，这显示是非常消耗时间的，所以可以采用链式存储，即有一个指针域（单链表），来记录下个结点的存储位置（地址），这样在插入和删除结点时只需要修改指针域即可，从而大量减少移动数据所消耗的时间。来看链表的定义：

    其中有两个元素，data为数据域，用于存储数据，next为指针域，用于存储下个结点的位置（地址）。
    单链表的示意图如下：

    Head指针为单链表的头指针，单链表L：L既是单链表的名字，也是其头指针。链表中的最后一个结点的指针域定义为空指针(NULL)。
    单链表的定义：当一个序列中只含有指向它的后继结点的链接时，就称该链表为单链表。



    那么什么是头指针呢？我们把指向第一个结点的指针称为头指针，那么每次访问链表时都可以从这个头指针依次遍历链表中的每个元素，

    这个head指针就是头指针。
    这个头指针的意义在于，在访问链表时，总要知道链表存储在什么位置（从何处开始访问），由于链表的特性（next指针），知道了头指针，那么整个链表的元素都能够被访问，也就是说头指针是必须存在的。示例如下：



    需要着重注意的是while那部分（通过头指针遍历完整个链表）。

    单链表有带头结点和不带头结点之分。
    上图为没有头结点的单链表，下图为带有头结点的单链表：
    1.单链表的初始化，即建立一个空链表。
            [plain] view plain copy*/

    //不带头结点的单链表的初始化
    /*void LinkedListInit1(LinkedList L)
    {
        L=NULL;
    }
    //带头结点的单链表的初始化
    void LinkedListInit2(LinkedList L)
    {
        L=(LNode *)malloc(sizeof(LNode));
        if(L==NULL)
        {
            printf("申请空间失败！");
            exit(0);
        }
        L->next=NULL;
    }
*/


   /* 那么什么又是头结点呢？很多时候，会在链表的头部附加一个结点，该结点的数据域可以不存储任何信息，这个结点称为头结点，
    头结点的指针域指向第一个结点，例如：*/

   // 那么这里的头指针又是谁呢，不在是指向第一个结点的指针，而是指向头结点的指针，例如：


   // 即root指针才是头指针。示例如下：

    //注：在Linux kernel中，定义头结点使用宏LIST_HEAD。


    /**
     * 第二个问题是双检索的相关,双检索为什么要判断2遍
     *
     * 内层判断  如果内层不加if判断,会实例化多次,就违背了单例模式的单例二字
     *
     * 外层判断: 试图想一想一种情况,当线程1走完了内层判断,对象已经实例化了,线程3也已经调用了getInstace函数,如果没有加外层的判断,线程3
     * 还是要继续等待线程2 的完成,加了外层判断就直接返回了实例化的对象,
     *
     * 即外层是为了提高效率,内层是第一次实例化的需要
     *
     *
     */


    /**
     * 经典问题
     * String str = “a“ + “b“ + “c“
     * String str = "abc"
     *
     * String a = "a"  String b = "b"   String c = "c"   => String str = a+b+c
     * 以上三个的equals 和  ==
     *
     * */


    public static void main(String[] args) {
        String str = "a" + "b" + "c";
        String str1 = "abc";
        String a = "a";  String b = "b";   String c = "c";
        String str2 = a+b+c;
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);

        System.out.println(str == str1);
        System.out.println(str == str2);
        System.out.println(str1 == str2);
        System.out.println(str.equals(str1) );
        System.out.println(str.equals(str2));
        System.out.println(str1.equals(str2));

    }
}
