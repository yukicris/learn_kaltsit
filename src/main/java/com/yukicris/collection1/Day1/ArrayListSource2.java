package com.yukicris.collection1.Day1;

import java.util.ArrayList;

public class ArrayListSource2 {
    //有初始化参数的ArrayList

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(8);

        //调用有初始化值的构造器
       /* public ArrayList(int initialCapacity) {
            if (initialCapacity > 0) {
                //直接把长度给到初始值
                this.elementData = new Object[initialCapacity];
            } else if (initialCapacity == 0) {
                //等于0就给个空构造{}
                this.elementData = EMPTY_ELEMENTDATA;
            } else {
                throw new IllegalArgumentException("Illegal Capacity: "+
                        initialCapacity);
            }
        }*/

        //然后再按照8的1.5倍扩容
        // 新容量 = 8+(8>>1)

    }
}
