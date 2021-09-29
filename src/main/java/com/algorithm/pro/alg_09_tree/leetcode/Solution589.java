package com.algorithm.pro.alg_09_tree.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 589 N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 * @author frankq
 * @date 2021/9/27
 */
public class Solution589 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        recur(root, list);
        return list;
    }

    public void recur(Node node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        List<Node> children_tree = node.children;
        for (Node n : children_tree) {
            recur(n, res);
        }
    }

    public static void main(String[] args) {

    }

}
