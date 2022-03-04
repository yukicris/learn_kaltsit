package com.yukicris.dataStructure;

import java.util.Arrays;

public class Maopao {
    public static void main(String[] args) {
        System.out.printf("初始化项目");
        //数组定义
        Maopao.shuzudingyi();
        // 冒泡排序
        Maopao.maopaopaixu();
    }



    public static int[] shuzudingyi () {
        // 定义数组1
        int [] a= new int[3];
        // 定义数组2
        int [] b = {1,2,3};
        // 定义二维数组1
        int [][] c= new int [3][3];
        // 定义二维数组2
        int [][] d = new int [][]{
                {},{},{}
        };
        System.out.println(""+ Arrays.toString(a));
        System.out.println(""+Arrays.toString(b));
        System.out.println(""+Arrays.toString(c));
        System.out.println(""+Arrays.toString(d));
        return a;
    }

    public static int[] maopaopaixu () {
        int a[] = {7,5,6,4,1,3,6,12,45,2};
        int temp;
        //排序,先循环一遍本体
        for (int i =0;i<a.length-1;i++) {
            //循环未遍历的部分
            for (int j=0;j<a.length-1-i;j++) {
                if (a[j]>a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.printf(""+Arrays.toString(a));
        return  a;
    }



}
