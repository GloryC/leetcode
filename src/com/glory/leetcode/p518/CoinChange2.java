package com.glory.leetcode.p518;

/**
 * @author zhanggc
 * @date 2022-02-03 09:56:38
 */
public class CoinChange2 {

    /**
     * 有一个背包，最大容量为 amount，有一系列物品 coins，每个物品的重量为 coins[i]，每个物品的数量无限。
     * 请问有多少种方法，能够把背包恰好装满？
     */
    static class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            // base case
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 1;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j - coins[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    }
                }
            }

            return dp[n][amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        Solution solution = new Solution();
        System.out.println(solution.change(5, coins));
    }

}
