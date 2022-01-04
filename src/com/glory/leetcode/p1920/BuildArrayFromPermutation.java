package com.glory.leetcode.p1920;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2022/1/4 23:40
 */
public class BuildArrayFromPermutation {

    static class Solution {
        public int[] buildArray(int[] nums) {
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                ans[i] = nums[nums[i]];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {};
        System.out.println(Arrays.toString(solution.buildArray(nums)));
    }

}
