package com.yukicris.dataStructure.mianshibaodian;

public class Test8 {
    public static void main(String[] args) {
        int [] nums = {6,7,1,2,3,4,5};
        System.out.println(findMin(nums));
    }


    //numbers = [3,4,5,1,2]
    //输出：1
    //找翻转数组最小值,这种不好,最好用二分法
    class Solution {
        public int findMin(int[] nums) {
            for(int i=1;i<nums.length;i++){
                if(nums[i]<nums[i-1]){
                    return nums[i];
                }
            }
            return nums[0];
        }
    }


    //二分法
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        //循环下标
        while (left<right) {
            //取中位 ,比如(80-60)/2+60 为70
            mid = left + (right - left)/2;
            if(nums[mid]>nums[right]) {
                // 最小数在右边
                left = mid + 1;
            }else if(nums[mid]<nums[right]){
                //最小数在左边
                right = mid;
            } else {
                //等于right ,比如2,2,2,3这种情况
                right = right-1;
            }
        }
        return nums[left];
    }
}
