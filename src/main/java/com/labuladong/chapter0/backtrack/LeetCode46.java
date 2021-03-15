package com.labuladong.chapter0.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 全排列 I
 *
 * @author yangqian
 * @date 2021/3/15
 */
public class LeetCode46 {

    public static void main(String[] args) {

    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     *
     * 回溯的核心方法
     *
     * 路径：记录在track中
     * 选择列表：nums 中不存在与track的那些元素
     * 结束条件：nums 中的元素全都在track中出现
     * @param nums
     * @param track
     */
    void backtrack(int[] nums, LinkedList<Integer> track) {

        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(track);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 作出选择
            track.add(nums[i]);
            // 进入下一层的决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }

    }

}
