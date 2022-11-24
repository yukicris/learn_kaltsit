package com.yukicris.collection1.Day2;

import java.util.Arrays;
import java.util.Vector;
@SuppressWarnings({"all"})//抑制下警告
public class Vector_Source {
    public static void main(String[] args) {
        Vector vector = new Vector();
        //默认给个10个
        /*    public Vector() {
        this(10);
        }
        */
        for (int i = 0; i <=10 ; i++) {
            vector.add(i);
            //一样,自动装箱
            /*public static Integer valueOf(int i) {
                if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
                    return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
                return new Integer(i);
            }*/

            //然后add
           /* public synchronized boolean add(E e) {
                modCount++;
                ensureCapacityHelper(elementCount + 1);
                elementData[elementCount++] = e;
                return true;
            }*/

            //不够就走扩容
           /* private void ensureCapacityHelper(int minCapacity) {
                // overflow-conscious code
                if (minCapacity - elementData.length > 0)
                    grow(minCapacity);
            }*/

            /*private void grow(int minCapacity) {
                // overflow-conscious code
                int oldCapacity = elementData.length;
                int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                        capacityIncrement : oldCapacity);
                        // 第一次进来就相当于是int newCapacity = oldCapacity + oldCapacity
                        //就相当于是翻了2倍了
                        //capacityIncrement这个参数是用的有参构造时候赋值指定初始容量,然后翻倍
                if (newCapacity - minCapacity < 0)
                    newCapacity = minCapacity;
                if (newCapacity - MAX_ARRAY_SIZE > 0)
                    newCapacity = hugeCapacity(minCapacity);
                elementData = Arrays.copyOf(elementData, newCapacity);
            }*/
        }
    }
}
