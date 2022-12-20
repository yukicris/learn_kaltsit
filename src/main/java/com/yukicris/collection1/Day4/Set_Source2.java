package com.yukicris.collection1.Day4;

import java.util.HashMap;
import java.util.HashSet;

public class Set_Source2 {
/**    // 添加一个元素时,先得到hash值,会转成索引值

    //找到存储数据表table,看这个索引位置是否已经存放有元素

    //如果没有,直接加入

    //如果有,调用equals进行比较,如果相同,就放弃添加,如果不相同,就添加到最后

    // 在java8中,如果一条链表元素个数超过Treeify_THRESHOLD(默认是8),并且table的大小>=MIN_TREEIFY_capacity(默认是64), table就是Node[] 这个数组
        //通俗点 就是只要一条链表长度大于8,就将链表转换为红黑树结构,不是直接转换,还需要进一步判断(当数组大小已经超过64并且链表中的元素个数超过默认8个的时候,将链表转换成红黑树)
    // 就会进行树化(红黑树)*/

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        //1 调用构造器
        /*  public HashSet() {
            map = new HashMap<>();
        }*/



        hashSet.add("java");
        //2 执行add()
       /* public boolean add(E e) {  //e="java"
            return map.put(e, PRESENT)==null;  //PRESENT = (static final) new Object始终是一个obj(占位置用)
        }*/
        //3 执行 put() 该方法会执行hash(Key)方法,得到key对应的一个hash值,算法是h = key.hashCode()^(h>>>16)右移16位
       /* public V put(K key, V value) {   // key "java"  value=PRESENT ,present是共享的,只占用一个空间
            return putVal(hash(key), key, value, false, true);
        }*/
        //4
        /* 核心代码
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
        boolean evict) {
            HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;  //定义了一些辅助变量
            // table 就是HashMap的一个属性,是一个数组,类型是Node[]
            // if语句表示 如果当前的table是null,或者大小=0 ,那么就是第一次扩容,给到16个空间
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;
            //1 根据key,得到hash值,去计算该key应该存放到table表的哪个索引位置,并且把这个位置的对象赋值给P
            //2 判断p是否为null
            // 2.1 如果p为null 表示还没有存放元素,就创立一个Node(key="java",value="PRESENT")
            // 2.2 如果不为null,就直接放在该位置
            if ((p = tab[i = (n - 1) & hash]) == null)
                tab[i] = newNode(hash, key, value, null);
            else {
                HashMap.Node<K,V> e; K k;
                if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                else if (p instanceof HashMap.TreeNode)
                    e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) {
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);
                            break;
                        }
                        if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;
            if (++size > threshold)
                resize();
            afterNodeInsertion(evict);
            return null;
        }*/

        hashSet.add("php");
        hashSet.add("java");
        System.out.println("set="+hashSet);



    }


}
