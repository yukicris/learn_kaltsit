package com.yukicris.dataStructure.mianshibaodian;

public class Test14 {
    //输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

    //输入: n = 1
    //输出: [1,2,3,4,5,6,7,8,9]
    //说明:
    //用返回一个整数列表来代替打印
    //n 为正整数



    public static void main(String[] args) {
       /* for (int i:printNumbers(2)) {
            System.out.println(i);
        }*/
        String i = "asdfgsg";
        //System.out.println(i.substring(0,i.length()));

    }
    //我的思路,10的n次方-1为最大,然后打印
    public static int[] printNumbers(int n) {
        //int i = 10<<n; 这个是二进制 ,用错了
        int i = (int)Math.pow(10,n);
        int [] nums = new int [i-1];
        for(int j=1;j<i;j++){
            nums[j-1] = j;
        }
        return nums;
    }

    //这个题主要考虑的是大数解法
    int [] res;
    char [] num;
    int cnt = 0;
    char [] Num = {'0','1','2','3','4','5','6','7','8','9'};
    public  int[] printNumbers1(int n) {
        res = new int [(int)Math.pow(10,n)-1];
        num = new char[n];
        for (int i=1;i<=n;++i) {
            dfs(0,i); //按位依次打印出来
        }
        return  res;
    }

    public void dfs(int x,int len) {
        if(x == len) {
            res[cnt++] = Integer.parseInt(String.valueOf(num).substring(0,len));
            return;
        }
        int start = x ==0?1:0;//首字母为0的时候再从1开始
        for (int i=start;i<=9;++i){
            num[x] = Num[i];
            dfs(x+1,len);
        }
    }


}
