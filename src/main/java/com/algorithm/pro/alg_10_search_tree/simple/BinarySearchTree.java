package com.algorithm.pro.alg_10_search_tree.simple;

/**
 * @author frankq
 * @date 2021/9/30
 */
public class BinarySearchTree {

    /**
     * 定义整棵树的根节点 root
     */
    private TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(10);
        bst.add(15);
        bst.add(16);
        bst.add(17);
        bst.add(18);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(9);
        bst.add(10);
        bst.add(11);
        bst.add(12);
        bst.add(13);
        bst.add(4);
        bst.add(7);
        bst.remove(10);
        System.out.println(bst);
        bst.remove(18);
        System.out.println(bst);
        bst.remove(12);
        System.out.println(bst);
        bst.remove(1);
        System.out.println(bst);
    }

    /**
     * 添加元素
     */
    public boolean add(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return true;
        }
        // 定义当前节点
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                // 添加到cur右子树上
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    return true;
                }
                cur = cur.right;
            } else if (cur.val > val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    return true;
                }
                cur = cur.left;
            } else {
                // 要么更新节点的值要么不操作
                return true;
            }
        }
        return false;
    }

    /**
     * 根据val查找节点
     */
    public TreeNode get(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                cur = cur.right;
            } else if (val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return cur;
    }

    /**
     * 删除二叉搜索树中的节点
     */
    public void remove(int val) {
        // 首先初步定义需要删除的节点 del
        TreeNode del = root;
        // 定义需要删除节点的父节点 del_p
        TreeNode del_p = null;

        while (del != null) {
            if (val > del.val) {
                // 从右子树中查找需要删除的节点
                del_p = del;
                del = del.right;
            } else if (val < del.val) {
                del_p = del;
                del = del.left;
            } else {
                // 找到要删除的节点了
                break;
            }
        }

        // 如果没有找到要删除的节点则直接返回
        if (del == null) {
            return;
        }

        // 判断不同的情况

        // 情况1: 如果要删除的节点有两个子节点
        if (del.left != null && del.right != null) {
            /**
             * * 将当前要删除节点的值用右子树中最小节点的值替换,最后把右子树中最小节点删除
             * * 而删除右子树中最小节点我们可以将del指针指向该右子树最小节点,同时del_p指向它的父节点
             * * 这样删除操作就可以和情况2合并了
             * */
            //从右子树中找最小节点及其父节点----其实就是找最左侧的叶子节点和其父节点
            TreeNode min = del.right;
            TreeNode min_p = null;
            while (min.left != null) {
                min_p = min;
                min = min.left;
            }
            // 用最小的节点值替换当前需要删除的节点值
            del.val = min.val;
            // 将del指向min, del_p 指向 min_p 方便删除最小节点
            del = min;
            del_p = min_p;
        }

        // 情况2: 如果要删除的节点有一个子节点(不论左子节点还是右子节点)或者它本身是叶子节点 我们需要找到它的子节点
        TreeNode del_child = null;
        if (del.right != null) {
            del_child = del.right;
        } else if (del.left != null) {
            del_child = del.left;
        }

        // 最后执行删除,将del_p指向del的指针指向del_child
        if (del_p.left == del) {
            del_p.left = del_child;
        } else if (del_p.right == del) {
            del_p.right = del_child;
        }

        // 同时清空del指向del_child指针
        del.left = null;
        del.right = null;
    }

    /**
     * 获取BST中的最大值节点
     */
    public TreeNode getMax() {
        // 根节点的右子树的最后侧叶子节点
        if (root == null) {
            return null;
        }
        TreeNode max = root;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }

    /**
     * 获取BST中最小值节点
     */
    public TreeNode getMin() {
        // 根节点左子树中的最左侧叶子节点
        if (root == null) {
            return null;
        }
        TreeNode min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    /**
     * 中序遍历
     */
    private void inOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrder(node.left, sb);
        sb.append(node.val).append("->");
        inOrder(node.right, sb);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, int val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }

        public int getVal() {
            return this.val;
        }
    }

}
