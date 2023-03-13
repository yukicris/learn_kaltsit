package com.yukicris.dataStructure.mianshibaodian;

import java.util.Arrays;

public class test1 {
    public static void main(String[] args) {
        //实现一个算法，确定一个字符串 s 的所有字符是否全都不同
        System.out.println(isUnique("abcdeffg"));

        //实现一个算法,找到字符串中的重复数字
        int nums[] = {1,2,3,4,4};
        System.out.println(findRepeatNumber(nums));
    }

    public static boolean isUnique(String abc){
        char ab[] = abc.toCharArray();
        Arrays.sort(ab);
        int length = abc.length();
        for(int i = 0;i<length-1;i++){
            if(ab[i]==ab[i+1]){
                return false;
            }
        }
        return true;
    }

    public  static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (nums.length-i-1>0){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }else{
                i++;
            }
        }
        return -1;
        /*
        官方用hashset做的
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;

        作者：LeetCode-Solution
        链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-b-4/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    }


}
