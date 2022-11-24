package com.yukicris.collection1.Day4;

import java.util.HashMap;
import java.util.HashSet;

public class SetSource {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        /*  底层其实是hashmap
        public HashSet() {
            map = new HashMap<>();
        }*/
        hashSet.add(null); //返回true
        hashSet.add(null); //返回false
        // 可以存放null值,但是只能存放一个null,元素不可重复
        // 执行add方法后,会返回一个boolean值,添加成功后,返回一个true,否则为false
        System.out.println("hashset="+hashSet);


        hashSet = new HashSet(); //重新赋值给set
        hashSet.add("lucy"); //true
        hashSet.add("lucy"); //false
        hashSet.add(new Dog("tom")); //true
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


