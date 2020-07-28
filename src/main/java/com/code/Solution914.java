package com.code;

import java.util.HashMap;
import java.util.Map;

public class Solution914 {

    /**
     * 给定一副牌，每张牌上都写着一个整数。
     *
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     *
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     *
     */

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : deck) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        System.out.println(map);
        int result = map.get(deck[0]);
        for (int key : map.keySet()) {
            if (map.get(key) >= 2) {
                System.out.println(" ==> " + getNumber(result, map.get(key)));
                if (getNumber(result, map.get(key)) == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int getNumber(int x, int y) {
        if(x==y){
            return x;
        }
        int big= Math.max(x, y);
        int small= Math.min(x, y);
        return getNumber(big-small,small);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,1,2,2,2,2,2,2};
        System.out.println(hasGroupsSizeX(a));
        System.out.println(getNumber(4, 6));
    }

}
