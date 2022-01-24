package com.running.utils;

/**
 * @author frankq
 * @date 2022/1/7
 */
public class Utils {

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
