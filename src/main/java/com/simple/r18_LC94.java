package com.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 * @author frankq
 * @date 2022/2/17
 */
public class r18_LC94 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recur(root, res);
        return res;
    }

    public void recur(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        recur(node.left, res);
        res.add(node.val);
        recur(node.right, res);
    }

}
