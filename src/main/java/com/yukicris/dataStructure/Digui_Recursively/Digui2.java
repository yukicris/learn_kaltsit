package com.yukicris.dataStructure.Digui_Recursively;

public class Digui2 {
    // 简单递归 1+2+3+...n
    public static void main(String[] args){
        System.out.println(sum(10));
    }
    public static int sum(int num){
        if(num == 1){
            return 1;  // 中止条件,调到条件成立为止
        }else{
            return num+sum(num-1);
        }
    }




}
