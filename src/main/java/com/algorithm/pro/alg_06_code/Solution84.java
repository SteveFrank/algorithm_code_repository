package com.algorithm.pro.alg_06_code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author frankq
 * @date 2021/9/18
 */
public class Solution84 {

    /**
     * 暴力破解的算法，会导致时间超过限制
     */
    public static int largestRectangleArea(int[] heights) {
        // 暴力破解
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            // 用两个指针分别向左右扩散，寻找以当前heights[i]为高度的最大矩形的左右两个下标
            int left = i;
            int right = i;
            while (left > 0) {
                // 向左扩散
                left --;
                if (heights[left] < heights[i]) {
                    left ++;
                    break;
                }
            }
            while (right < heights.length - 1) {
                right ++;
                if (heights[right] < heights[i]) {
                    right --;
                    break;
                }
            }
            int tempArea = (right - left + 1) * heights[i];
            max = Math.max(max, tempArea);
        }
        return max;
    }

    /**
     * 单调栈 哨兵 柱状图处理
     */
    public static int largestRectangleArea_1(int[] heights) {
        // 特殊处理
        if (heights == null) {
            return 0;
        }
        // 构造新的数组，同时安排好哨兵
        int[] h = new int[heights.length + 2];
        h[0] = -1;
        h[h.length - 1] = -1;
        System.arraycopy(heights, 0, h, 1, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        // 遍历前将左侧的哨兵入站
        stack.push(0);
        // 定义最大面积
        int max = 0;
        for (int i = 1; i < h.length; i ++) {
            while (h[i] < h[stack.peek()]) {
                // 栈顶元素对应的高度
                int height = h[stack.pop()];
                max = Math.max(max, (i - 1 - stack.peek()) * height);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[] {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea_1(heights));
    }

}
