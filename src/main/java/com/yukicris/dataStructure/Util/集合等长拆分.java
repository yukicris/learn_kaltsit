package com.yukicris.dataStructure.Util;

import java.util.ArrayList;
import java.util.List;

public class 集合等长拆分 {
    public static List<List<String>> groupList(List<String> list) {
        List<List<String>> listGroup = new ArrayList<List<String>>();
        int listSize = list.size();
        //子集合的长度
        int toIndex = 2;
        for (int i = 0; i < list.size(); i += 2) {
            if (i + 2 > listSize) {
                toIndex = listSize - i;
            }
            List<String> newList = list.subList(i, i + toIndex);
            listGroup.add(newList);
        }
        return listGroup;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        List<List<String>> lists = groupList(list);
        System.out.println("list:" + list.toString());
        System.out.println(lists);
        //[[1,2],[3,4],[5,6],[7]]
    }
}
