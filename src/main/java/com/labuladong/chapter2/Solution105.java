package com.labuladong.chapter2;


/**
 *
 * 利用前序遍历和中序遍历还原一个二叉树
 *
 * @author yangqian
 * @date 2021/3/9
 */
public class Solution105 {

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(
                preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1
        );
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        // 前序遍历的第一个节点就是头节点 root 节点
        // 该节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];

        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                // 找到了头节点在中序遍历中的位置
                index = i;
                break;
            }
        }

        // 从前序遍历查找到的root节点 集合中序遍历中root节点的位置
        // 可以求出左子树的节点数
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder,index + 1, inEnd);

        return root;

    }

}
