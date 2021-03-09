package com.labuladong.chapter2;

/**
 *
 * 利用中序遍历和后序遍历还原一个二叉树
 *
 * @author yangqian
 * @date 2021/3/9
 */
public class Solution106 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(
                inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1
        );
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        // 从后续遍历中 找到root节点
        int rootVal = postorder[postEnd];

        // 在中序遍历中找到对应的root节点的位置
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // 左子树的节点总数
        int leftSize = index - inStart;
        // 根节点的数据
        TreeNode root = new TreeNode(rootVal);

        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

}
