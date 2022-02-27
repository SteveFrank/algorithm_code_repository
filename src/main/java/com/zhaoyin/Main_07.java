package com.zhaoyin;

import java.util.Scanner;

/**
 * @author frankq
 * @date 2022/2/26
 */
public class Main_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int f1 = 1, f2 = 1;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }
        System.out.println(f2);
    }

}
