package com.yukicris.dataStructure.Huisu;

import java.util.ArrayList;
import java.util.List;

public class demo1 {
    //全排列
    //从n个不同元素中任取m（m≤n）个元素，按照一定的顺序排列起来，
    //叫做从n个不同元素中取出m个元素的一个排列。当m=n时所有的排列情况叫全排列。
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1,2,3};


        dfs(arr,new ArrayList<>());
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }


    public static List<List<Integer>> huisu(int[] arr,List<Integer> list){
        List<Integer> temp = new ArrayList<>();
        if(arr.length==list.size()){

        }
        return null;
    }


    public static List<List<Integer>> dfs( int[] arr,List<Integer> list){
        List<Integer> temp = new ArrayList<>(list);
        if (arr.length == list.size()){
            res.add(temp);
        }
        for (int i=0;i<arr.length;i++){
            if (temp.contains(arr[i])){
                continue;
            }
            temp.add(arr[i]);
            dfs(arr,temp);
            temp.remove(temp.size()-1);
        }
        return res;
    }

}
