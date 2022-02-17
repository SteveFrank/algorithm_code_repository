package com.dcxy.dc_11_greedy;

/**
 * @author frankq
 * @date 2022/2/9
 */
public class Solution45_JumpGame {

    /**
     * 找到最少的步数
     * 可以看到这道题目中，策略决策具有后效性了
     * 思路1：反向跳跃的做法
     *  我们可以从最后一个位置出发进行逆推，
     *  我们首先可以得到哪些位置，可以一步直接跳到最后
     *  而为了让步数最少，我们可以选择让最后一次跳跃最远。也就是说，最后一条之前所在的位置
     *  距离最后最远。
     * 思路2：正向跳跃的做法
     */
    public int jump(int[] nums) {
        int steps = 0;
        int curPosition = nums.length - 1;
        while (curPosition > 0) {
            for (int i = 0; i < curPosition; i++) {
                if (i + nums[i] >= curPosition) {
                    curPosition = i;
                    steps ++;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * 正向
     */
    public int jump_start(int[] nums) {
        int steps = 0;
        // 定义双指针
        int farthest = 0;
        int nextFarthest = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            nextFarthest = Math.max(nextFarthest, i + nums[i]);
            if (i == farthest) {
                farthest = nextFarthest;
                steps ++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        int steps = 0;
        int farthest = 0;
        int nextFarthest = 0;
        for (int i = 0; i < nums.length; i ++) {
            nextFarthest = Math.max(farthest, i + nums[i]);
            if (i == farthest) {
                farthest = nextFarthest;
                steps ++;
            }
        }
    }

}
