package p322;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/8 22:21
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i < coin) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        int[] coins = {2};
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, 3));
    }

}
