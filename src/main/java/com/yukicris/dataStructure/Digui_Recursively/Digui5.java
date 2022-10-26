package com.yukicris.dataStructure.Digui_Recursively;

public class Digui5 {
    //给定一个数字三角形,如下,在这个三角形中寻找一条从顶部到底边的路径,
    //使得这个路径上所经过的数字之和最大,路径上的每一步都只能往左下或者右下走,求最大和

    /*       7
           3   8
        8    1    0
     2     7   4     4
   4    5    2    6    5*/

  //思路就是顶端的数和下面的2个左右三角形的最大路径相加
  // a(i,j) 第i行第j列
  // s(i,j) 表示从a(i,j) 到底边的最大路径值

  /*  s(i,j){ a(i,j)      i=n  最后一行,最大路径值为它自己
            { max{s(i+1,j)(左),s(i+1,j+1)(右)}这两个数取一个max+a(i,j)   i<n

          */
    //
    public static void main(String[] args) {
        //输入参数
        int[][] str = new int[][]{
                {7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}
        };
        int n = str.length-1;
        int i = 0;
        int j = 0;
        System.out.println(count(str,n,i,j));
    }




  //递归  时间复杂度 2^n
    public static int count(int [] [] s,int n,int i,int j){

       //当为最后一排的时候
        if(i == n){
            return s[i][j];
        }else{
            //行数小于n的时候
            int x = count(s,n,i+1,j);
            int y = count(s,n,i+1,j+1);
            return Math.max(x,y)+s[i][j];
        }

    }


}
