package com.labuladong.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangqian
 * @date 2021/3/9
 */
public class Solution230 {

    public static void main(String[] args) {

    }

    private int rank = 0;
    private int res = 0;

    int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    /**
     * 节省时间与内存
     * @param root
     * @param k
     */
    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank ++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

}
