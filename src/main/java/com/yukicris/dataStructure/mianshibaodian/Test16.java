package com.yukicris.dataStructure.mianshibaodian;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class Test16 {
    /*请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
    而'*'表示它前面的字符可以出现任意次（含0次）。
    在本题中，匹配是指字符串的所有字符匹配整个模式。
    例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


   /* s = "aa"
    p = "a"
    输出: false
    解释: "a" 无法匹配 "aa" 整个字符串。*/


    public boolean isMatch(String s, String p) {
        char sToChar[] = s.toCharArray();
        char pToChar[] = p.toCharArray();
        char pToNewChar[] = new char[sToChar.length];
        for(int i=0;i<pToChar.length;i++){
            if (pToChar[i]=='.') {
                pToNewChar[i] = '.';
            }else if (pToChar[i]=='*') {  //合整体
                char index = ' ';
                for(int n=i-1;n>0;--n){
                    if (pToChar[n]==pToChar[i-1]){
                        index= (char) (pToChar[n]+'*');
                    }else{
                        break;
                    }
                }
            }else {   //合整体
                pToNewChar[i] = pToChar[i];
            }
        }
        //然后再用for做两个比较..写到后面我自己都写乱了.,思路就是把a*当成一个整体做成新的数组然后再比较看,还是直接看官方的吧

        return false;
    }




    //官方写法,困难题咱不强求
    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean [][] f = new boolean[m+1][n+1];
        f[0][0] = true;  //空字符匹配
        for (int i=0;i<=m;++i){
            for(int j=1;j<=n;++j){
                if (p.charAt(j-1)=='*'){ //判断*位
                    f[i][j] = f[i][j-2];  //保存a*中的a
                    if (matches(s,p,i,j-1)) { //比较a和s[i]是否相等
                        f[i][j] = f[i][j] || f[i-1][j];
                    }
                } else {
                    if (matches(s,p,i,j)){
                        f[i][j] = f[i-1][j-1];
                    }
                }
            }
        }
        return f[m][n];

    }

    public boolean matches(String s,String p,int i,int j) {
        if (i==0){
            return false;
        }
        if (p.charAt(j-1)=='.'){
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
