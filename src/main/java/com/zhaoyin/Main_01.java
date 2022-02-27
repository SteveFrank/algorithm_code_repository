package com.zhaoyin;

import java.util.Scanner;

/**
 * @author frankq
 * @date 2022/2/26
 */
public class Main_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        if (len == 1)
            System.out.println(1);
        else if (len == 2)
            System.out.println(4);
        else{
            System.out.println(len*(len-1)/2+len+1);
        }
    }

}
