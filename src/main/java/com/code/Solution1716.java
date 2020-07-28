package com.code;

/**
 * @author yangqian
 * @date 2020/3/24
 */
public class Solution1716 {

    /**
     * 输入： [1,2,3,1]
     * 输出： 4
     * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
     *
     * 输入： [2,7,9,3,1]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
     *
     * 输入： [2,1,4,5,3,1,1,3]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     *
     * @param nums
     * @return
     */
    public static int massage(int[] nums) {
        int maxTime = 0;
        int index = 1;
        int maxIndex = index;
        while (index < nums.length) {
            int temp1 = nums[index];
            if (nums.length > (index + 1)) {
                int temp = nums[index - 1] + nums[index + 1];
                if (temp1 < temp && maxIndex + 1 != index) {
                    maxIndex = index + 1;
                    temp1 = temp;
                } else {
                    maxIndex = index;
                }
                System.out.println(" ==> maxIndex: " + maxIndex);
            }

            maxTime += temp1;
            System.out.println(" ==> index: " + index);
            index += 3;
        }
        System.out.println(" ===> " + index);
        return maxTime;
    }

    public static int massage_1(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            int c = Math.max(b, a + num);
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 1};
        int[] b = new int[]{2, 7, 9, 3, 1};
        int[] c = new int[]{2, 1, 4, 5, 3, 1, 1, 3};
        int[] d = new int[]{1, 3, 1};
        System.out.println(massage(d));
        System.out.println(massage_1(a));
        System.out.println(massage_1(b));
        System.out.println(massage_1(c));
    }

}
