package com.glory.leetcode.p416;

/**
 * @author zhanggc
 * @date 2022-02-02 23:36:00
 */
public class PartitionEqualSubsetSum {

    /**
     * 那么对于这个问题，我们可以先对集合求和，得出 sum，把问题转化为背包问题：
     * <p>
     * 给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。
     * 现在让你装物品，是否存在一种装法，能够恰好将背包装满？
     */
    static class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            // 和为奇数时，不可能划分成两个和相等的集合
            if (sum % 2 != 0) {
                return false;
            }

            sum /= 2;

            boolean[] dp = new boolean[sum + 1];
            // base case
            dp[0] = true;

            for (int num : nums) {
                // j 应该从后往前反向遍历，因为每个物品（或者说数字）只能用一次，以免之前的结果影响其他的结果。
                for (int j = sum; j >= 0; j--) {
                    if (j - num >= 0) {
                        dp[j] = dp[j] || dp[j - num];
                    }
                }
            }
            return dp[sum];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.canPartition(nums));
    }

}
