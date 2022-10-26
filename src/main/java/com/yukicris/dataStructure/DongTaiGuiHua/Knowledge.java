package com.yukicris.dataStructure.DongTaiGuiHua;

public class Knowledge {
    // 就是如果我知道有个过程会被反复调用,动态规划在算过一次以后,把答案记下来,下回合在遇到就直接调
    //空间换时间

    //斐波那契数列 第n项
    // f(n) = f(n-1)+f(n-2)

    public static void main(String[] args) {

    }

    public static int f(int n){
        if(n ==1){
            return 1;
        }
        if(n ==2){
            return 1;
        }
        if(n>2){
            // 递归这里面每一步都会把下一步重复,比如f(6)会去拿f(5)+f(4),f(5)又会去拿到f(4)
            //其中会有很多的重复值
            return f(n-1)+f(n-2);
        }
        return -1;
        //如果用动态规划(也就是加缓存),我把f(1)~f(6)都保存,再计算,就是动态规划
    }
}
