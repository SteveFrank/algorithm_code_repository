package com.zhaoyin;

import java.util.Scanner;

/**
 * 判断好数
 * @author frankq
 * @date 2022/2/26
 */
public class Main_06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            // 包含2、5、6、9中任意个，且不包含3、4、7的即为好数
            if ((str.contains("2") || str.contains("5") || str.contains("6") || str.contains("9")) && (!str.contains("3") && !str.contains("4") && !str.contains("7"))) {
                count++;
            }
        }
        System.out.println(count);
    }

}
