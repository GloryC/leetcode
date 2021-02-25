package p322;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/8 22:21
 */
public class Solution {

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return (dp[amount] == max) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2};
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, 3));
    }

}
