package com.yukicris.collection1.Day4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set_Method {
    public static void main(String[] args) {
        //以Set接口实现类HashSet的对象
        //不能存放重复的对象,可以添加一个null
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john");
        set.add("jack");
        set.add(null);
        set.add(null); //再次添加null没用
        //set= [null, john, lucy, jack]  取出顺序和保存顺序不一样,且null只能有一个
        // 注意: 取出的顺序虽然不是添加的顺序,但是它固定
        set.add("mary");
        for (int i = 0; i < 10; i++) {
            //取10次顺序一致
            //System.out.printf("set= "+set);
        }


        //遍历,迭代器
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        } 

        //增强for
        for (Object obj:set) {
            System.out.println(" "+obj );
        }

        //但是传统的for循环就不行了,因为没用索引,没用提供get方法


        //删除
        set.remove(null);
        System.out.println("set= "+set);
    }
}
