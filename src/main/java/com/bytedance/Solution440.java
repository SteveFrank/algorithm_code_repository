package com.bytedance;

/**
 * @author frankq
 * @date 2023/7/23
 */
public class Solution440 {

    public static void main(String[] args) {

    }

    public int findKthNumber(int n, int k) {
        int cnt = 0;
        int num = 1;
        while (true) {
            if (cnt == k - 1) {
                break;
            }
            int temp = count((long) num, n);
            if (cnt + temp >= k) {
                num *= 10;
                cnt ++;
            } else if (cnt + temp < k) {
                num ++;
                cnt += temp;
            }
        }
        return num;
    }

    private int count(long num, int n) {
        int cnt = 0;
        int width = 1;
        while (true) {
            if (num + width - 1 <= n) {
                cnt += width;
                num *= 10;
                width *= 10;
            } else {
                if (n - num >= 0) {
                    cnt += n - num + 1;
                }
                break;
            }
        }
        return cnt;
    }

}
