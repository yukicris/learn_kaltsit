package com.yukicris.collection1.Day1;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListSource {

    public static void main(String[] args) {
        // 源码解读
        //注意注意,IDEA默认情况下,Debug显示的数据是简化后的,如果需要看到完整的数据,需要做设置
        //idea设置,debugger,dataview,java,去掉enablealterativce 去掉勾选,就可以看到list中的一些null值了
        // 使用无参构造器创建ArrayList对象
        /*public ArrayList() {
            this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        }
        DEFAULTCAPACITY_EMPTY_ELEMENTDATA 这里等于{}
        */
        ArrayList arrayList = new ArrayList();

        // 添加1-10个数据
        //这里会进行装箱,int 转Integer,-128~127
        /*     public static Integer valueOf(int i) {
            if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
                return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
            return new Integer(i);
        }*/

        for (int i = 0; i <= 10; i++) {
            arrayList.add(i);
         /*   public boolean add(E e) {
                ensureCapacityInternal(size + 1);  // Increments modCount!!
                elementData[size++] = e;
                return true;
            }*/
            //ensureCapacityInternal确认是否扩容

         /*   private void ensureCapacityInternal(int minCapacity) {
                //第一次进来,给他付个10
                // 当对象为无参构造的时候
                if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                    //它的最小值就为 max(10,最小值) 中取一个大的,一般就是10
                    minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
                }
                //调用扩容方法
                ensureExplicitCapacity(minCapacity);

            }*/
            // 扩容方法     minCapacity: 需要的最小容量
           /* private void ensureExplicitCapacity(int minCapacity) {
                modCount++;  //这个参数记录集合被修改的次数

                // 如果elementData的大小不够了,就要去扩容了
                //比如就是最小值超过了我赋的初始的(elementData.length)10,就要开始扩容了
                if (minCapacity - elementData.length > 0)
                    grow(minCapacity);
            }*/

            //扩容
         /*   private void grow(int minCapacity) {
                // overflow-conscious code
                int oldCapacity = elementData.length;  //当前容量
                int newCapacity = oldCapacity + (oldCapacity >> 1); //新容量
                if (newCapacity - minCapacity < 0)
                    //这里是第一次进来,属于特殊情况,newCapacity = 0+0/2=0
                    所以要把它赋个10
                    newCapacity = minCapacity; //所以这里就是最小指10
                if (newCapacity - MAX_ARRAY_SIZE > 0)
                    newCapacity = hugeCapacity(minCapacity);
                // minCapacity is usually close to size, so this is a win:
                //拷贝数据到新的数组空间里面
                elementData = Arrays.copyOf(elementData, newCapacity);
            }*/
        }

        //添加11-15数据
        for (int i = 11; i <= 15; i++) {
            arrayList.add(i);
        }

        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(null);
    }
}
