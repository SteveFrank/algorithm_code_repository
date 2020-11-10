package com.leetcode.book.primary.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangqian
 * @date 2020/10/10
 */
public class Solution04 {

    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }

}
