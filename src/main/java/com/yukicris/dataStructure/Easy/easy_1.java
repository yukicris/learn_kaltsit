package com.yukicris.dataStructure.Easy;

import java.util.Arrays;

public class easy_1 {
    //删除排序数组中的重复项,返回排序后的长度
    public static int removeDuplicates(int[] nums) {
        //记录重复的个数
        int count = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                //1 此处提一下,跟此题无关数组没有remove,只能用个值进行代替nums[i]=0;,然后arr = Arrays.copyOf(arr, arr.length-1);进行缩容
                count++;
            }else{
                //如果不重复了,就把后面的挪到前面的位置[0,1,2,3,4]
                nums[i-count]=nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        int arr [] = Arrays.copyOf(nums, nums.length-count);
        //缩容
        System.out.println(Arrays.toString(arr));
        return nums.length-count;
    }

    public static void main(String[] args) {
        int str[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(str));
    }
}
