package com.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author frankq
 * @date 2022/2/14
 */
public class r14_LC102 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> res) {
        // terminal
        if(root == null) {
            return;
        }
        int size = res.size();
        if (size - 1 < level) {
            res.add(new ArrayList<>());
        }
        List<Integer> list = res.get(level);
        list.add(root.val);
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        return res;
    }

    public void dfs2(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        int size = res.size();
        if (size - 1 < level) {
            res.add(new ArrayList<>());
        }
        List<Integer> list = res.get(level);
        list.add(root.val);
        dfs2(root.left, level + 1, res);
        dfs2(root.right, level + 2, res);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
