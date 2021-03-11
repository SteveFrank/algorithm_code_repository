package com.labuladong.chapter0;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangqian
 * @date 2021/3/11
 */
public class Solution46 {

    public static void main(String[] args) {

    }

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 输入一组不重复的数字，返回全排列数据
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track) {
        // base case 触发结束条件
        if (track.size() == nums.length) {
            // 找到了一组排列，将这组排列添加到最后的结果中
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

}
