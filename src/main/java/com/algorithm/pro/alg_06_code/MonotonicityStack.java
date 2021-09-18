package com.algorithm.pro.alg_06_code;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author frankq
 * @date 2021/9/18
 */
public class MonotonicityStack {

    private int[] getLeftMinNum(int[] src) {
        int[] result = new int[src.length];
        Deque<Integer> monotoneStack = new ArrayDeque<>();
        for (int i = 0; i < src.length; i++) {
            while (!monotoneStack.isEmpty() && src[i] <= monotoneStack.peek()) {
                monotoneStack.pop();
            }
            if (!monotoneStack.isEmpty()) {
                result[i] = monotoneStack.peek();
            } else {
                result[i] = -1;
            }
            monotoneStack.push(src[i]);
        }
        return result;
    }

    /**
     * 单调栈 + 哨兵
     * 哨兵：代表了一种边界情况，所以一般可以使用哨兵来减少一些边界判断
     */
    private int[] getLeftMinNumOptimize(int[] src) {
        int[] result = new int[src.length];
        Deque<Integer> monotoneStack = new ArrayDeque<>();
        // 提前加入哨兵
        monotoneStack.push(-1);
        for (int i = 0; i < src.length; i ++) {
            while (src[i] <= monotoneStack.peek()) {
                monotoneStack.pop();
            }
            result[i] = monotoneStack.peek();
            monotoneStack.push(src[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] param = new int[] {6, 10, 3, 7, 4, 4, 12, 5};
        System.out.println(Arrays.toString(new MonotonicityStack().getLeftMinNum(param)));
    }

}
