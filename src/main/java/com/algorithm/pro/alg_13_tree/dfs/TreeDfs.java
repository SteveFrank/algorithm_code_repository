package com.algorithm.pro.alg_13_tree.dfs;

import com.algorithm.pro.alg_13_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author frankq
 * @date 2022/1/24
 */
public class TreeDfs {

    private void dfs(TreeNode root, int level, List<List<Integer>> results) {
        // terminal 已经下探到最底部节点
        if (results.size() == level) {
            results.add(new ArrayList<>());
            return;
        }
        // process current level node here
        // 记录当前节点已经访问
        results.get(level).add(root.val);
        // drill down if node not visited
        if (root.left != null) {
            dfs(root.left, level + 1, results);
        }
        if (root.right != null) {
            dfs(root.right, level + 1, results);
        }
    }

    public static void main(String[] args) {

    }

}
