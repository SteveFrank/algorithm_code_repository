package com.zhaoyin;

import java.util.Arrays;

/**
 *
 * 每艘船只能载两人
 *
 * @author frankq
 * @date 2022/2/26
 */
public class Main_05 {

    public void Main_05() {

    }

    public int countLeastBoat(Integer []nums,int maxLoad){
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.length-1;;
        while(i<j) {
            if(nums[i]+nums[j] <= maxLoad) {
                i++;
                j--;
            } else {
                j--;
            }
            count++;
        }
        return count + (j==i?1:0);
    }

}
