package p518;

/**
 * @author Glory
 * @date 2020/6/18 16:14
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        Solution solution = new Solution();
        System.out.println(solution.change(5, coins));
    }

}
