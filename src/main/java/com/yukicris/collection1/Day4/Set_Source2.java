package com.yukicris.collection1.Day4;

import java.util.HashMap;
import java.util.HashSet;

public class Set_Source2 {
/**    // 添加一个元素时,先得到hash值,会转成索引值

    //找到存储数据表table,看这个索引位置是否已经存放有元素
        table就是图里的那个竖着的蓝色的
    //如果没有,直接加入

    //如果有,调用equals进行比较,如果相同,就放弃添加,如果不相同,就添加到最后

    // 在java8中,如果一条链表元素个数超过Treeify_THRESHOLD(默认是8),并且table的大小>=MIN_TREEIFY_capacity(默认是64), table就是Node[] 这个数组
        //通俗点 就是只要一条链表长度大于8,就将链表转换为红黑树结构,不是直接转换,还需要进一步判断(当数组大小已经超过64并且链表中的元素个数超过默认8个的时候,将链表转换成红黑树)
    // 就会进行树化(红黑树)*/

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();



        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("set="+hashSet);



    }
    /**
     * 然后是扩容机制
     *
     * 1 HashSet的底层是hashmap,第一次添加时,table数组扩容到16,临界值threshold是16*加载因子0.75(loadFactor) =12
     * 如果table 数组使用到了临界值12,就会再次扩容到16*2=32,新的临界值是32*0.75=24  以此类推
     * 在Java8中如果一条链表的元素个数到达TREE_THRESHOLD默认是8,并且table的大小>=MIN_TREEIFY_CAPACITY默认64,就会进行树化(红黑树),
     * 否则忍采用数组扩容机制
     *
     */


}
