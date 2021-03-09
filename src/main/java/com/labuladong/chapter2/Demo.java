package com.labuladong.chapter2;

/**
 * @author yangqian
 * @date 2021/3/8
 */
public class Demo {

    /**
     *
     * void traverse(TreeNode root) {
     *     // 前序遍历
     *     traverse(root.left);
     *     // 中序遍历
     *     traverse(root.right);
     *     // 后序遍历
     * }
     *
     */

    public int count(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // 自己加上子树的节点数就是整棵树的节点数
        return 1 + count(root.right) + count(root.left);
    }



}
