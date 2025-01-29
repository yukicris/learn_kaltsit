package com.yukicris.dataStructure.mianshibaodian;

public class Test17 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     *
     *  
     *
     * 示例：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     */

    //21题.这个不难
    class Solution {
        public int[] exchange(int[] nums) {
            int [] nums2 = new int[nums.length];
            int index = 0;
            int index2 = 0;
            for(int i=0;i<nums.length;i++){
                if((nums[i]&1)==0){
                    //为偶数
                    nums2[nums.length-1-index] = nums[i];
                    index++;
                }else if((nums[i]&1)==1){
                    //为奇数
                    nums2[index2]= nums[i];
                    index2++;
                }
            }
            return nums2;
        }
    }
}
