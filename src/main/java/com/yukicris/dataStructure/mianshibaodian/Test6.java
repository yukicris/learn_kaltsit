package com.yukicris.dataStructure.mianshibaodian;

public class Test6 {
    //斐波那契
/*    写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。*/
    public static void main(String[] args) {
        // 递归不好
        // System.out.println(fbnq(5));
        System.out.println(fib(10));
    }

    //用递归 很容易超时
    public static int fbnq(int n){
        if(n<2) {
            return n;
        }
        return fbnq(n-2)+fbnq(n-1);
    }


    //动态规划法,把加数1 ,加数2 ,和 摆在一起,会发现和加数1 会变成加数2 ,加数2 会变成和,和是新的加数1+加数2
    public static int fib(int n) {
        int m = 1000000007;
        if (n<2){
            return n;
        }
        //加数1
        int jiashu1 =0;
        int jiashu2 =0;
        int he = 1;
        for(int i=2;i<=n;i++){
            jiashu1=jiashu2;
            jiashu2=he;
            he = (jiashu1+jiashu2)%m;
        }

        return he;

    }


}
