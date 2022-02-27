package com.simple;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author frankq
 * @date 2022/2/24
 */
public class r24_LC01 {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++ i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[] {hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }





    public static int[] twoSum1(int[] nums, int target) {
        // key放值 value放索引
        Map<Integer, Integer> dictCache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dictCache.containsKey(target - nums[i])) {
                return new int[] {dictCache.get(target - nums[i]), i};
            }
            dictCache.put(nums[i], i);
        }
        return new int[]{};
    }

}
