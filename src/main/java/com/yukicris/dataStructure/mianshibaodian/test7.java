package com.yukicris.dataStructure.mianshibaodian;

import java.util.Arrays;

public class test7 {
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

    //原理是从最后一个台阶考虑
    //最后一节有2种跳法,一阶或者二阶,所以还是类似于斐波那契函数  f(n) = f(n-1)+f(n-2)


    public static void main(String[] args) {
            //一样的,递归会导致超时,可以加一个数组保存递归结果
            System.out.println(test1(7));

    }
    private int array1[];
    public static int test1(int n){
        test7 t7 = new test7();
        return  t7.testjump(n);
    }

    public  int testjump(int n) {
        //赋一个初始值
        array1 = new int[n+1];
        Arrays.fill(array1,-1);
        //调用方法
        test7 t7 = new test7();
        return t7.jump(n);
    }

    //这个其实是对的,但是不知道怎么main调不到
    public  int jump(int n){
        //取保存的数据
        
        if (array1[n]!=-1){
            return array1[n];
        }
        //终止条件
        if(n==1||n==0){
            return 1;
        }
        //记得取模
        array1[n] = (jump(n-1)+jump(n-2))%1000_000_007;
        return array1[n];
    }


    //动态规划法
    public static int fib(int n) {
        int m = 1000000007;
        if (n<2){
            return n;
        }
        //加数1
        int jiashu1 =1;
        int jiashu2 =1;
        int he = 0;
        for(int i=2;i<=n;i++){
            he = (jiashu1+jiashu2)%m;
            jiashu1=jiashu2;
            jiashu2=he;

        }

        return he;

    }
}
