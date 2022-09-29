package com.yukicris.Thread.ThreadDay3;

public class TestLambda2 {
    public static void main(String[] args) {
        Ilove love = (int a)->{
                System.out.println("i love you"+a);
        };
        love.love(2);
        // 简化1 去掉参数类型
        Ilove love2 = (a)->{
            System.out.println("i love you"+a);
        };
        love2.love(2);

        //简化2,去掉括号
        Ilove love3 = a->{
            System.out.println("i love you"+a);
        };
        love3.love(2);

        //简化3,去掉花括号,类似if,只有一行就可以简化
        Ilove love4 = a->System.out.println("i love you"+a);
        love4.love(2);


        //总结: Lambda表达式只能有一行代码的情况下,才能简化成一行,如果有多行,那么久用代码块来包裹
          //前提是接口为函数式接口
        // 多个参数,也可以去掉参数类型,要去掉就都去掉,必须加上括号


        //局部内部类
       /* class Love2 implements  Ilove{
            @Override
            public void love(int a) {
                System.out.println("i love you"+a);
            }

        }*/
    }
}


interface  Ilove{
    void love(int a);
}

class Love implements Ilove{
    @Override
    public void love(int a) {
        System.out.println("i love you"+a);
    }
}