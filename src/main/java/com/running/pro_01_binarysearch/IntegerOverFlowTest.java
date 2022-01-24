package com.running.pro_01_binarysearch;

/**
 * @author frankq
 * @date 2022/1/7
 */
public class IntegerOverFlowTest {

    public static void main(String[] args) {
        method1();
        System.out.println("===============================");
        int l = 0;
        int r = Integer.MAX_VALUE - 1;

        int m = (l + r) >>> 1;
        System.out.println(m);

        // 在右侧 (正数运算 等价 与 除以 2)
        l = m + 1;
        m = (l + r) >>> 1;
        System.out.println(m);

        System.out.println(126 + 63);
        System.out.println((126 + 63) / 2);
        System.out.println((126 + 63) >>> 1);

    }

    private static void method1() {
        int l = 0;
        int r = Integer.MAX_VALUE - 1;

        int m = l + (r - l) / 2;
        System.out.println(m);

        // 在右侧
        l = m + 1;
        m = l + (r - l) / 2;
        System.out.println(m);

        System.out.println();
    }


    
}
