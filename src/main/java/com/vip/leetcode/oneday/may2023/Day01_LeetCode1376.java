package com.vip.leetcode.oneday.may2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author frankq
 * @date 2023/5/1
 */
public class Day01_LeetCode1376 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // 构造一颗树，根据构造的树，到每个节点，遍历求和
        // 或者构建图，通过对图的深度遍历得出答案
        // 使用HashMap来构建图
        Map<Integer, List<Integer>> g = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            g.putIfAbsent(manager[i], new ArrayList<>());
            g.get(manager[i]).add(i);
        }
        // 从根节点 开始进行 DFS 并返回 总时间
        return dfs(headID, informTime, g);
    }

    /**
     * @param cur           当前位置
     * @param informTime    通知时间
     * @param g             图
     */
    public int dfs(int cur, int[] informTime, Map<Integer, List<Integer>> g) {
        int res = 0;
        // 遍历当前节点的邻居节点
        for (int neighbor : g.getOrDefault(cur, new ArrayList<Integer>())) {
            res = Math.max(res, dfs(neighbor, informTime, g));
        }
        // 返回当前节点被通知需要的时间，以及所有邻居节点被通知所需要的最大时间
        return informTime[cur] + res;
    }

    public static void main(String[] args) {

    }

}
