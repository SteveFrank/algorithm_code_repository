package com.zhaoyin;

import java.util.LinkedHashMap;

/**
 *
 * 计算字符串匹配
 *
 * @author frankq
 * @date 2022/2/26
 */
public class Main_02 {

    public static void main(String[] args) {
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        String str = "sssdhibdhidhi";
        for (char c: str.toCharArray()) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c,hashMap.get(c) + 1);
            } else {
                hashMap.put(c,1);
            }
        }

        for (Character character : hashMap.keySet()) {
            System.out.printf("%s%s",character,hashMap.get(character));
        }
    }

}
