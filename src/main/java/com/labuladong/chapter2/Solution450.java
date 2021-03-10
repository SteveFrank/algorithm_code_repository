package com.labuladong.chapter2;

/**
 *
 * BST 中删除某个节点
 *
 * @author yangqian
 * @date 2021/3/10
 */
public class Solution450 {

    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 找到了需要删除的节点元素
            // 分情况讨论
            // 情况1: 如果需要删除的节点自己已经是叶子节点了，可以直接删除
            // 情况2: 如果需要删除的节点左右子节点有一个是空节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 情况3: 如果需要删除的节点有两个子节点
            // 找出最小的哪一个节点
            TreeNode minNode = getMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key) {
            // 比当前节点大，从左子树找
            root.left = deleteNode(root.left, key);
        } else {
            // 比当前接地那小，从右子树找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * 针对节点有子节点的情况，需要找寻出子节点中最小的那一个节点
     * @param node
     * @return
     */
    TreeNode getMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}
