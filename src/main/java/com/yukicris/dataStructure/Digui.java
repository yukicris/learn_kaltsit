package com.yukicris.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Digui {
    ArrayList<ArrayList<Integer>> res;

/*
    //递归算法
    *//*给出一组数字，返回该组数字的所有排列
    例如：[1,2,3]的所有排列如下*//*
    public static void main(String[] args) {
        int a [] = {1,2,3};
        Digui d = new Digui();
        ArrayList<Integer> list = new ArrayList<>();
        d.digui(list,a);
        //System.out.printf(""+d.res);
    }


    public  void digui (ArrayList<Integer> list,int[] nums) {

        //Arrays.sort(a);
        // 判断到最后一位的时候,返回数组
        if (list.size() == nums.length) {
            res.add(list);
            return;
        }
        for (int i = 0;i< nums.length;i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                digui(list,nums);
                list.remove(list.size()-1);
            }
        }
    }*/
    public static void main(String[] args) {
        int a [] = {1,2,3};
        Digui d = new Digui();
        d.permute(a);
        System.out.printf(""+d.res.toString());
    }

    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length < 1)
            return res;
        //对数组元素进行从小到大排序
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();

        solve(list, nums);

        return res;
    }

    private void solve(ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                solve(list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
