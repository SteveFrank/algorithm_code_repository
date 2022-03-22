package com.simple;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 全排列
 *
 * @author frankq
 * @date 2022/3/2
 */
public class r25_L046 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        r25_L046 l046 = new r25_L046();
        l046.permute(nums);
        System.out.println(l046.res);
    }

    public List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backtrack(nums, track);
            track.removeLast();
        }
    }


}
