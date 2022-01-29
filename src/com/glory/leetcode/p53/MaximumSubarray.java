package com.glory.leetcode.p53;

/**
 * @author zhanggc
 * @date 2022-01-29 20:56:01
 */
public class MaximumSubarray {

    static class Solution {
        /**
         * 思路：要么自成一派，要么和前面的子数组合并
         */
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }

            // 定义：dp[i] 记录以 nums[i] 为结尾的「最大子数组和」
//            int[] dp = new int[n];
            // base case
            int dp_0 = nums[0], dp_1 = 0, res = dp_0;
            for (int i = 1; i < n; i++) {
                // dp[i] = max(nums[i], nums[i] + dp[i-1])
                dp_1 = Math.max(nums[i], nums[i] + dp_0);
                dp_0 = dp_1;
                res = Math.max(res, dp_1);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
