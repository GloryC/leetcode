package com.glory.leetcode.p494;

import java.util.HashMap;

/**
 * @author zhanggc
 * @date 2022-01-31 11:11:07
 */
public class TargetSum2 {

    static class Solution {
        /**
         * 回溯算法
         * 消除重叠子问题
         */
        public int findTargetSumWays(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }

            return dp(nums, 0, target);
        }

        // 备忘录
        HashMap<String, Integer> memo = new HashMap<>();

        private int dp(int[] nums, int i, int rest) {
            // base case
            if (i == nums.length) {
                if (rest == 0) {
                    return 1;
                }
                return 0;
            }

            // 把它俩转成字符串才能作为哈希表的键
            String key = i + "," + rest;
            // 避免重复计算
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            // 还是穷举
            int result = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
            // 记入备忘录
            memo.put(key, result);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

}
