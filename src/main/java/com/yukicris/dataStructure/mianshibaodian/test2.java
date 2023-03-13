package com.yukicris.dataStructure.mianshibaodian;

public class test2 {
    public static void main(String[] args) {
        //二维数组中找到一个数是否存在
        int matrix[][]= {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};


        System.out.println(findNumberIn2DArray(matrix,5));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //直接找
       /* for(int[] abc:matrix){
            for(int ab:abc){
                if(ab == target) {
                    return true;
                }
            }
        }*/
        //二分找
        for(int []abc:matrix){
            if (search(abc,target)==true){
                return true;
            }
        }
        return false;

    }

    public static boolean search(int[] abc, int target) {
        //二分找
        int low = 0;
        int high = abc.length-1;
        while(low<=high){
            int mid = high-low/2+low;
            int nums = abc[mid];
            if (nums==target){
                return true;
            } else if (nums<target) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return false;

    }

}
