package com.labuladong.chapter0.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangqian
 * @date 2021/4/4
 */
public class LeetCode124 {

    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return ans;
    }

    int ans = Integer.MIN_VALUE;

    public int oneSideMax(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));

        this.ans = Math.max(this.ans, left + right + root.val);

        return Math.max(left, right) + root.val;
    }

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
