package com.yukicris.dataStructure.mianshibaodian;

public class Test13 {
    //实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。


    public static void main(String[] args) {
        System.out.println(myPow(2,4));
    }

    //思路大体是的,但是这样性能很差,要遍历n遍
    public static double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        if (n==1) {
            return x;
        }
        if (n==-1){
            return 1.0/x;
        }
        if(n>1){
            x = x*myPow(x,n-=1);
        }
        return x;
    }

    // 官方解 ,快速冥算法 x^64等于x^2^2^2^2^2^2,即每次都是上次结果的平方,只需要6次遍历
    public static double myPow1(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);  //n小于0的时候取n次方的倒数10^-2=1/(10^2),这里加了个负号取绝对值了
    }

    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;       //2^4等于2^2 * 2^2,   2^5=2^2 * 2^2 *2
    }


    //官方解2
    //以后再看,有位运算,先记上面这一种

}
