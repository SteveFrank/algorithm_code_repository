package com.labuladong.chapter0.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * TODO LeetCode 46 全排列II 未完全实现代码
 *
 * @author yangqian
 * @date 2021/3/11
 */
public class Solution47 {

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        solution47.permuteUnique(new int[]{1, 1, 2});
        System.out.println(solution47.res);
    }

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track) {

        if (nums.length == track.size()) {
            res.add(track);
            return;
        }

        for (int num : nums) {
            track.add(num);

            if (track.size() == nums.length) {
                String trackStr = track.toString();
                for (List<Integer> resStr : res) {
                    if (trackStr.equalsIgnoreCase(resStr.toString())) {
                        break;
                    }
                }
            }

            backtrack(nums, track);
            track.removeLast();
        }

    }

}
