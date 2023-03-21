package com.yukicris.dataStructure.mianshibaodian;

public class Test9 {
   /* 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

    例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
             

    示例 1：

    输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    输出：true
    示例 2：

    输入：board = [["a","b"],["c","d"]], word = "abcd"
    输出：false*/


    public static void main(String[] args) {
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist2(board,word));
    }
    //我的思路,仅供参考,没有考虑全面(因为可以往左走,不一定是下一个,可能是上一个连续),性能也差(ABCD,ABC没有连上D再走会把这个错误解重复再遍历一遍)
    public static boolean exist(char[][] board, String word) {
        //先遍历
        int end = 1;
        for (int i = 0; i < board.length; i++) {
            for(int j = 0;j<board[i].length;j++) {
                if (word.charAt(end)==(board[i][j])) {
                    //找到头了,开始寻找下一个节点
                    end ++;
                    if (exist1(board[i][j++],word.charAt(end))){
                        j++;
                    }else if (exist1(board[i++][j],word.charAt(end))) {
                        i++;
                    }
                }
            }
        }
        return false;

    }

    public static boolean exist1(char board, char word) {
        if (word==(board)) {
            return true;
        }
        return false;
    }


    //正式解
   /* 流程：
    1、 探索每个坐标点开始是否能找到word
    2、 如果首字母匹配上（假设坐标为i,j），就向附近单元格移动，去匹配第1个字母
    3、 如果匹配失败则退回(i,j)位置；如果匹配上，假设坐标为(i+1,j);则继续循环上述步骤，
    直至所有字母都匹配完成
    4、 同时为了避免走重复的单元格，需要额外记录走过的坐标；需要注意的是，当退回到之前的单元格时，
    要从记录中删除当前的坐标；举例来说，A->B->C,如果C没有匹配上或者C之后的字符串没有匹配上，
    那么退回到B的时候，就要把C从记录删除*/

    public static boolean exist2(char[][] board, String word) {
        // 先遍历,然后维护一个等大的已遍历的数组保存结果,就是说如果相邻可以匹配,就保存个true在那个位置上,最后连起来就是一堆true
        boolean [][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for(int j = 0;j<board[0].length;j++) {
                //去挨个匹配当前字段是否符合连续字段
                boolean flag = check(board,word,i,j,visited,0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean check(char[][] board, String word,int i,int j, boolean [][] visited,int k) {
        //判断当前字段是哪个字段,以及递归判断条件
        if (board[i][j]!=word.charAt(k)){
            return false;
        }else if (k==word.length()-1) {
            //匹配到了最后个字段,返回成功,递归结束
            return true;
        }
        visited[i][j] = true;
        //比较
        int [][]dir = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean result = false;
        //遍历四临域
        for (int[] dd:dir){
            int newi = i+dd[0];
            int newj = j+dd[1];
            //比较对象未超出矩阵
            if (newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length){
                if(!visited[newi][newj]){
                    //执行下次递归
                    boolean flag = check(board,word,newi,newj,visited,k+1);
                    if(flag){
                        result  = true;
                        //递归结束
                        break;
                    }
                }
            }
        }
        //保存错误结果
        visited[i][j] = false;
        return result;

    }

}
