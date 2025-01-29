package com.yukicris.collection1.Day4;

import java.util.HashMap;
import java.util.HashSet;

public class SetSource {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        /*  底层其实是hashmap
        1 public HashSet() {
            map = new HashMap<>();
        }
        */
        hashSet.add(null); //返回true
        hashSet.add(null); //返回false
        /*
        2 执行第一个add方法
        public boolean add(E e) { //e是一个字符串常量,此处位E,泛型
        return map.put(e, PRESENT)==null;   //Present是final修饰的一个静态new Object,起到占位作用
        //private static final Object PRESENT = new Object();
        }
        3  执行put方法  key是我传的字符串常量   value是PRESENT,一个共享占位对象
        该方法会执行hashcode方法,可以得到
        public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
        }

        3.1 hash方法 ,教程没有,自己理解一下,大致是,每个对象Object都有其对应的hashcode,这个hashcode方法是c传过来的(native),然后这里这个
        方法(高16位与低16位异或,保存二者的共同特征)可以使这个key避免冲突,是个唯一值
        static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }

        4 执行 putVal

        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;  // 1 定义辅助变量
        //2 下面这个table,是hashmap的一个属性,类型是Node[]
        //if语句,表示,如果当前的table是null,或者大小=0,就是第一次扩容,到16个空间
        if ((tab = table) == null || (n = tab.length) == 0)
            //第一次进来,为null,  resize这个方法点进去,里头第一次赋值,跑
            //2.1
            //         else {               // zero initial threshold signifies using defaults
            //            newCap = DEFAULT_INITIAL_CAPACITY;  //16
            //            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);  //负载因子0.75*16=12
                            //到12 就提醒你该扩容了
                            //这里就体现出hashmap的不安全的地方了,这个12是预留4个位置怕其他线程也把数据加到这个hashmap里面,导致他突然不够用
                            //然后就会卡死在那里,0.75是通过大量实验得到的一个值,但是不一定完全准确够用(打比方我班里50个凳子给40个人用,如果突然来比10多的人,就不够用了)
            //        }
            // 2.2 然后赋值
            // @SuppressWarnings({"rawtypes","unchecked"})
            //Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
            //table = newTab;

            n = (tab = resize()).length;
            //这句话执行完后,table就变成16大小的Node[]了,且值都为null

        // 3.1根据传入的key,得到的hash值,去计算该key应该存放到table表的哪个索引位置
        // 并且把这个位置的对象,赋给 辅助变量p
        // 3.2 判断p是否为null
        // 3.2.1 p为null,表示还没有存放元素,就创建一个Node(key="字符串常量",value="PRESENT")
        // 放在该位置 tab[i] = newNode(hash, key, value, null);
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
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
        ++modCount;   // 修改次数+1
        // 4 第一次进来 ,有一个数据了,size=1,threshold=12,不用再次扩容
        if (++size > threshold)
            resize();
        // 下面这个方法对于hashmap来说是个null方法,主要作用是留给子类比如linkedhashmap实现的
        afterNodeInsertion(evict);
        return null;  //成功,如果返回不是null,就会返回上面那个oldValue,是原来的值,没有添加进去
        }
        */
        // 可以存放null值,但是只能存放一个null,元素不可重复
        // 执行add方法后,会返回一个boolean值,添加成功后,返回一个true,否则为false
        System.out.println("hashset="+hashSet);


        hashSet = new HashSet(); //重新赋值给set
        hashSet.add("lucy"); //true
        hashSet.add("lucy"); //false
        hashSet.add(new Dog("tom")); //true
        // 这里开始看第二个add方法
        //前几个还是一样的
        /*public boolean add(E e) { //e是一个字符串常量,此处位E,泛型
            return map.put(e, PRESENT)==null;   //Present是final修饰的一个静态new Object,起到占位作用
            //private static final Object PRESENT = new Object();
        }
        3  执行put方法  key是我传的字符串常量   value是PRESENT,一个共享占位对象
        该方法会执行hashcode方法,可以得到
        public V put(K key, V value) {
            return putVal(hash(key), key, value, false, true);
        }

        3.1 hash方法 ,教程没有,自己理解一下,大致是,每个对象Object都有其对应的hashcode,这个hashcode方法是c传过来的(native),然后这里这个
        方法(高16位与低16位异或,保存二者的共同特征)可以使这个key避免冲突,是个唯一值
        static final int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }*/

        // 下面几步我会把上面第一次进入的步骤省一省
        // 经过hash算法后,把这个key对应位置索引算出来,i应该是0-15,然后把这个Node放到i这个位置
       /* if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
            //如果重复了,hash值是一样的,就是说那个i是一样的,走else
          else {
            //下面就是hash值索引是一样的,但是我存的东西不一定一样的情况,比如都是3
            // 一个开发技巧提示: 在需要局部变量的时候再去定义
            Node<K,V> e; K k;
            if (p.hash == hash &&    // 如果当前索引位置对应的链表的第一个元素和准备添加的key的hash值一样
                //并且满足下面两个条件之一:  准备加入的key和p指向的Node 节点的key 是同一个对象/ 不是同一个对象但是内容相同
                // 就不能加入
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)  //再判断p 是不是一颗红黑树,如果是一棵红黑树,就调用putTreeVal来添加
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {    // 如果当前table对应的索引位置,p(也就是那个Node)已经是一个链表,就使用for循环比较
            // (1) 依次和该链表每个元素比较后,都不相同,则加入到该链表的最后
            // (2) 依次和该链表的每一个元素比较过程中,发现相同情况,就直接break ,就是上面说的,比如我存key,tom和jack都是3,就是把jack放到tom后头
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        // 尾插法,加入最后
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st // TREEIFY_THRESHOLD==8,如果binCount >=7
                            // 在把这个元素添加到链表后,立即判断,该链表是否有8个节点,
                            // 如果达到了8个节点,就把当前链表红黑树化  treeifyBin
                            // 注意,在转成红黑树时,还进行一个判断,如果该table数组的大小<64,他会先进行扩容
                            //  if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
                            //            resize();
                            // 如果上面条件成立,先table扩容,只有上面条件不成立,才进行树化
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&   //如果链表里面有一个值与我要存的值相同,直接break
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;  //不满足(e=p.next)==null,说明下一个位置有值,就把p指向下一个,回到上面的if  e = p.next,直到为null的时候,添加node
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
        ++modCount;   // 修改次数+1
        // 4 第二次进来 ,有一个数据了,size=2,threshold=12,不用再次扩容
        if (++size > threshold)
            resize();
        // 下面这个方法对于hashmap来说是个null方法,主要作用是留给子类比如linkedhashmap实现的
        afterNodeInsertion(evict);
        return null;  //成功,如果返回不是null,就会返回上面那个oldValue,是原来的值,没有添加进去
        }*/



        hashSet.add(new Dog("tom"));//不同对象,可以添加成功 true


        //再加深一下,非常经典面试题
        hashSet.add(new String("yew"));//true
        hashSet.add(new String("yew"));//false,这个加入不了,

        System.out.println("set="+hashSet);

    }


}

class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}


