package com.algorithm.pro.alg_15_binarySearch;

/**
 * @author frankq
 * @date 2022/1/27
 */
public class BinarySearchDemo {

    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (array[mid] == right) {
                return mid;
            } else if (array[mid] == target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int recurBinarySearch(int[] array, int target, int left, int right) {
        // terminal
        if (left > right) {
            return -1;
        }
        int mid = left + ((left + right) >> 1);
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            // drill down
            return recurBinarySearch(array, target, left, mid - 1);
        } else {
            return recurBinarySearch(array, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {

    }

}
