package com.algorithm.pro.alg_14_greedy;


/**
 * @author frankq
 * @date 2022/1/26
 */
public class Solution860 {

    public boolean lemonadeChange(int[] bills) {
        // 定义 5元和10元 的钞票张数
        int five, ten;
        five = ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                // 不需要找零
                five ++;
            } else if (bill == 10) {
                if (five <= 0) {
                    return false;
                }
                five --;
                ten ++;
            } else {
                // 20元
                if (ten > 0 && five > 0) {
                    ten --;
                    five --;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
