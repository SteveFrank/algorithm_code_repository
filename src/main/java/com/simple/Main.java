package com.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author frankq
 * @date 2022/2/24
 */
public class Main {

    public static void main(String[] args) {

    }

    public int FirstNotRepeatingChar(String str) {
        if (str == null) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), i);
                counter.put(str.charAt(i), 1);
            } else {
                counter.put(str.charAt(i), counter.getOrDefault(str.charAt(i), 0) + 1);
            }
        }
        for (Character key : counter.keySet()) {
            if (counter.get(key) == 1) {
                return map.get(key);
            }
        }
        return -1;
    }

}
