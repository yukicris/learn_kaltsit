package com.yukicris.dataStructure.Digui_Recursively;

public class Digui3 {
    //镁佳面试题

    /**
     Given a string, compute **recursively** (no loops) the number of "22" substrings in the string. The "22" substrings should not overlap.

     count22("22abc22") → 2
     count22("abc22x22x22") → 3
     count22("222") → 1
     */

// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法

        public static void main(String[] args) {
            System.out.println(count22("22x22x2222") );
            System.out.println(count22("222") );
            String str = "22x22x2222";
            /*System.out.println(str.indexOf("22"));*/
            System.out.println(str.charAt(0));
        }

        public static int count22(String str) {
            //我的一个思路是逢22截掉,当时没写出来
            //递归头,剩下的字符串没有22了
            if (str.indexOf("22")<0){
                return 0;
            }
            //递归体,截取22
            else if(str.indexOf("22")>=0){
                int i = str.indexOf("22");
                //substring是从1开始的
                str = str.substring(i+2,str.length());
                //用函数自己做计数器..这个真的没有想到
                return  count22(str)+1;
            }
            return count22(str);
        }

    public static int count22_2(String str) {
        //网上的不截取,charAt方式
        //不过charat只适用于单个字符
        return -1;
    }


}
