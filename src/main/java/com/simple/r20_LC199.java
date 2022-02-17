package com.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author frankq
 * @date 2022/2/17
 */
public class r20_LC199 {

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        right(root, 0, temp);
        temp.forEach(t -> {
            res.add(t.get(t.size() - 1));
        });
        return res;
    }

    public void right(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        int size = res.size();
        if (size - 1 < level) {
            res.add(new ArrayList<>());
        }
        List<Integer> temp = res.get(level);
        temp.add(root.val);
        right(root.left, level + 1, res);
        right(root.right, level + 1, res);
    }

}
