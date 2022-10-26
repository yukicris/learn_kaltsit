package com.yukicris.dataStructure.Digui_Recursively;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Digui4 {
    /**
     * 假定一对大兔子每月可以生一对小兔子,每对新生的小兔子一个月可以长成大兔子具备繁殖能力,
     * 如果不发生死亡,且每次都生下一雌一雄,最初一对小兔子一年以后公有多少对兔子
     */

    // 0  1  2  3  4  5  6  7  8  9  10  11  12
  //小  1  0  1  1  2  3  5  8..
  //大  0  1  1  2  3  5  8  13..
  //总  1  1  2  3  5  8  13  21..

    //也就是斐波那契数列

    // f(n){  1  n=0
    //     {  1  n=1
    //     {  f(n-1)+f(n-2)   n>1
    public static void main(String[] args) {
        System.out.println(countTuzi(12));
    }


    public static int countTuzi(int month){
        // 递归思想
        /*if(month==0){
            return 0;
        }
        if(month==1){
            return 1;
        }*/
        if(month<2){
            return 1;
        }else{
            return countTuzi(month-1)+countTuzi(month-2);
        }
    }



}
