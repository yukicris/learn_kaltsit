package com.yukicris.collection1;

import java.util.ArrayList;

public class homework1 {
    // 韩顺平家庭作业1
    // 封装一个新闻类,包含标题和内容属性,提供get,set方法 ,重写toString方法,打印对象时只打印标题
    // 见xinwen1

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList<>();
        arrayList.add(new Xinwen1("新闻1,xssdsdsdsdsd"));
        arrayList.add(new Xinwen1("新闻2,sdsdafadsfasdf"));

        int size = arrayList.size();
        for (int i = size-1;i>=0;i--) {
            System.out.println(arrayList.get(i));
            //处理新闻标题进行截取
            // *这里arrayList.get(i)的tostring方法了,因为已经被重写了
            Xinwen1 xinwen1 = (Xinwen1) arrayList.get(i);
            System.out.println(processTitle(xinwen1.getTitle()));
        }
    }
    //处理标题,process 处理,标题字数大于10,截取10位,后面加...
    public static String processTitle (String title ) {
        if (null == title) {
            return "";
        }
        if (title.length()>10) {
            return  title.substring(0,10)+"...";
        }else {
            return title;
        }
    }
}
