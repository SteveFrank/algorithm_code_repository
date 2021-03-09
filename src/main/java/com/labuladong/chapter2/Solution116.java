package com.labuladong.chapter2;

/**
 * @author yangqian
 * @date 2021/3/8
 */
public class Solution116 {

    public static void main(String[] args) {

    }


    /**
     * 将需求细化
     * 「将每一层二叉树节点连接起来」可以细化成「将每两个相邻节点都连接起来」
     * @param root
     * @return
     */
    public Node connect(Node root) {
        // base case
        if (root == null) {
            return null;
        }

        // 辅助函数
        connectTwoNode(root.left, root.right);

        return root;
    }

    void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        node1.next = node2;

        // 连接相同父节点下的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);

        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }

}
