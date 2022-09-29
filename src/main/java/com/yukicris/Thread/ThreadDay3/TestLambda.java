package com.yukicris.Thread.ThreadDay3;

import org.aspectj.weaver.IClassFileProvider;

public class TestLambda {
    /*
    这里的2,3,4,5,6为一步步的推导过程,逐步简化
     */



    // 3静态内部类
    static class Like2 implements  ILike{
        @Override
        public void lambda() {
            System.out.println("I like Lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();
        like = new Like2();
        like.lambda();


        //4 局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like Lambda3");
            }
        }


        like = new Like3();
        like.lambda();


        //5 匿名内部类: 没有类的名称,必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like Lambda4");
            }
        };

        //6 用lambda再简化匿名内部类
        like =()-> {
            System.out.println("I like Lambda4");
        };
        like.lambda();
    }
}

//1 定义一个函数式接口
interface ILike{
    void lambda();
}

//2 实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
