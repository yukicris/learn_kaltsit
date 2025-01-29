package com.yukicris.dataStructure.mianshibaodian;

public class Test10 {
    //给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
    // 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
    //
    //2 <= n <= 58

    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/jian-sheng-zi-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 补一个知识点,数组交错求和
     * Math.pow(-1.i)
     *
     * Math.pow(x,y)  x为底数,y为指数,就是用来算平方的,上面用-1在循环里可以做交错加减 ,比如 nums[0]+nums[1]-nums[2]+nums[3]...
     */

    //动态规划..思路大致理解,还要多练习
    public int cuttingRope(int n) {
        // 剪下j,剩下1段,即 j*(n-j),   如果剩下的还要再减 即 j*dp(n-j)
        int [] dp = new int[n+1]; //保存拆分下来长度能够再次被拆分的最大乘积

        //状态转移方程
        //0和1的时候都是1段
        for(int i = 2;i<=n;i++){//减下的第一段长度
            int curMax = 0; //最大乘积
            for (int j=1;j<i;j++){//获取拆分下来的i能够再次被拆分的最大积
                curMax = Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));//比较不拆,i这段拆1段,i这段拆多段看谁大
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

}
