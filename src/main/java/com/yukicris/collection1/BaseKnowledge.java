package com.yukicris.collection1;

public class BaseKnowledge {
    //1 String ,StringBuffer, StringBuilder的区别
    /**
     * String 值是不可变的,是用final修饰的,每次操作都会创建新对象
     *
     * StringBuffer 值是可变的,可以被多次修改,线程安全
     *
     * StringBuilder 值是可变的,可以被修改,线程不安全,但是速度更快
     */


    //2 集合的效率等问题
    // List,Map,Set
    /**
     * Set(集合) 没有按序进行排序,且不可重复,
     *在set集合中，hashset 集合比较两个对象是否相等，首先看
     * hashcode 方法是否相等，然后看 equals 方法是否相等。
     * 实现了HashSet方法存取速度很快,TreeSet可以对集合里的对象进行排序
     *
     *
     * List(列表) 按线性方法存储,可以重复, ArrayList 为长度可变的数组,访问速度较快,插入和删除较慢
     * LinkedList在实现中采用了链表的数据接口,插入和删除较快,访问较慢
     * Vector 底层也是数组,查询快,插入和删除慢,但是线程安全,效率低
     *
     *
     * Map(映射) 为键和值映射的集合 ,键是不允许重复的
     * hashMap比hashTable快, hashmap线程不安全,键和值可以为null
     */

    //3 ArrayList的扩容机制
    /**
     * 重点方法:
     * private void grow(int minCapacity) {
     *           // 获取到ArrayList中elementData数组的内存空间长度
     *           int oldCapacity = elementData.length;
     *          // 扩容至原来的1.5倍
     *          int newCapacity = oldCapacity + (oldCapacity >> 1);
     *          // 再判断一下新数组的容量够不够，够了就直接使用这个长度创建新数组，
     *           // 不够就将数组长度设置为需要的长度
     *          if (newCapacity - minCapacity < 0)
     *              newCapacity = minCapacity;
     *          //若预设值大于默认的最大值检查是否溢出
     *          if (newCapacity - MAX_ARRAY_SIZE > 0)
     *              newCapacity = hugeCapacity(minCapacity);
     *          // 调用Arrays.copyOf方法将elementData数组指向新的内存空间时newCapacity的连续空间
     *          // 并将elementData的数据复制到新的内存空间
     *          elementData = Arrays.copyOf(elementData, newCapacity);
     *      }
     *
     *  从此方法中我们可以清晰的看出其实ArrayList扩容的本质就是计算出新的扩容数组的size后实例化，并将原有数组内容复制到新数组中去
     */

    // 4 静态变量和实例变量的区别
    /**
     * 静态变量前要加 static 关键字，而实例变量（成员变量）前则不加。
     * 在程序运行时的区别：实例变量属于某个对象的属性，必须创建了实例对象，其中的实例变量才会被分配空间，才能使用这个实例变量。
     *
     * 静态变量不属于某个实例对象，而是属于类，所以也称为类变量，只要程序加载了类的字节码，不用创建任何实例对象，
     * 静态变量就会被分配空间，只分配一次，静态变量就可以被使用了。总之，实例变量必须创建对象后才可以通过这个对象来使用，静态变量则可以直接使用类名来引用。
     */

}
