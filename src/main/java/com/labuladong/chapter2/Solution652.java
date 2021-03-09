package com.labuladong.chapter2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangqian
 * @date 2021/3/9
 */
public class Solution652 {

    public static void main(String[] args) {

    }

    /**
     * 记录所有子树出现的次数
     */
    private HashMap<String, Integer> memo = new HashMap<>();
    /**
     * 记录重复的子树根节点
     */
    LinkedList<TreeNode> result = new LinkedList<>();

    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }

    /**
     * 遍历
     * @param root
     * @return
     */
    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree, 0);

        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            result.add(root);
        }

        memo.put(subTree, freq + 1);

        return subTree;

    }

}
