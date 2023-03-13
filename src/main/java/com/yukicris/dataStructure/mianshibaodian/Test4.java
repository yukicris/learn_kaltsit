package com.yukicris.dataStructure.mianshibaodian;

import java.util.HashMap;
import java.util.Map;

public class Test4 {

    //思路大致明白,需要在多复习
    public static void main(String[] args) {
        //输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
    }


    private Map<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //构建哈希映射
        indexMap = new HashMap<Integer, Integer>();
        for (int i =0;i<n;i++) {
            //中序遍历的节点和值
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }


    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {


        //前序遍历第一个点必定为根节点
        int preorder_root = preorder[preorder_left];//就是节点0对应的值
        //在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        //把根节点建立出来
        TreeNode root = new TreeNode((preorder[preorder_root]));

        //左子树节点数目
        int size_left_subtree = inorder_root-inorder_left;

        //递归构造左子树,链接到根节点
        //先遍历中 [从左边界+1 开始的 size_left_subtree] 个元素就对应了中序遍历中 [从左边界开始 到 根节点定位-1] 的元素
        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size_left_subtree,inorder_left,inorder_root-1);

        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);

        return root;


    }
}
