package com.zhaoyin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * target 求和匹配
 *
 * @author frankq
 * @date 2022/2/26
 */
public class Main_03 {

    public static void main(String[] args) {
        int[] candidates = {2,6,1,7,4,9};
        System.out.println(combinationSum(candidates,20));
    }
    static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        //对数组进行排序
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        dfs(list, candidates, target, 0);
        return lists;
    }

    private static void dfs(List<Integer> list, int[] candidates, int target, int start) {
        //递归的终止条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                //因为这个数和上个数相同，所以从这个数开始的所有情况，在上个数里面都考虑过了，需要跳过
                if (i != start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                dfs(list, candidates, target - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

}
