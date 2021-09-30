package com.algorithm.pro.alg_10_search_tree.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 * 可以按 任意顺序 返回答案。
 * @author frankq
 * @date 2021/9/30
 */
public class Solution95 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return recurGen(1, n);
    }

    public List<TreeNode> recurGen(int start, int end) {
        // 首先定义退出条件
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            // 左子树
            List<TreeNode> lefts = recurGen(start, i - 1);
            // 右子树
            List<TreeNode> rights = recurGen(i + 1, end);
            // 以 i 为根节点
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;

                    // 添加到集合
                    res.add(root);
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {

    }

}
