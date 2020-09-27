package com.leetcode.tree.simpletree;

import java.util.ArrayList;
import java.util.List;

/**
 *  20200927
 *  * 235. 二叉搜索树的最近公共祖先
 *  * * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *  * @date 2020/9/27
 */
public class Solution235 {

    public static void main(String[] args) {

    }

    /**
     * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
     * root = [6,2,8,0,4,7,9,null,null,3,5]
     * * 所有节点的值都是唯一的。
     * * p、q 为不同节点且均存在于给定的二叉搜索树中。
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // p的路径
        List<TreeNode> path_p = getPath(root, p);
        // q的路径
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++ i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

}
