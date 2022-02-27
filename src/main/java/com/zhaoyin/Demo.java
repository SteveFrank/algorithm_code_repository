package com.zhaoyin;

/**
 * @author frankq
 * @date 2022/2/26
 */
public class Demo {
    public int countNum (int L, int R, int x) {
        // write code here
        char xCh = String.valueOf(x).toCharArray()[0];
        int count = 0;
        for (int i = L; i <= R; i ++) {
            String temp = String.valueOf(i);
            for (Character ch : temp.toCharArray()) {
                if (ch == xCh) {
                    count ++;
                }
            }
        }
        return count;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串
     */
    public String maxDictionaryOrder(String s) {
        if (s == null) {
            return null;
        }
        dfs(s);
        return result;
    }

    private String result = "";

    public String dfs(String s) {
        if (s.length() == 0) {
            return "";
        }
        // write code here
        char[] chars = s.toCharArray();
        // 先找到最大的那一个，就是当前的起始位置
        char maxChar = 'a';
        int maxIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch > maxChar) {
                maxChar = ch;
                maxIndex = i;
            }
        }
        // 起始位置为maxIndex
        String temp = s.substring(maxIndex);
        // 从这个起始位置开始找到连续的字符串，再去掉这些拼接到result后递归传递下去
        StringBuilder resultBuilder = new StringBuilder(result);
        for (int i = 0; i < temp.toCharArray().length; i++) {
            char ch = temp.charAt(i);
            if (ch == maxChar) {
                resultBuilder.append(ch);
                maxIndex = i;
            }
        }
        result = resultBuilder.toString();
        if (maxIndex != temp.toCharArray().length - 1) {
            temp = temp.substring(maxIndex + 1);
            System.out.println(temp);
            dfs(temp);
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "cmbchina";
        Demo demo = new Demo();
        String result = demo.maxDictionaryOrder(s);
        System.out.println(result);
    }
}
