package p123;

/**
 * @author Glory
 * @date 2020/3/9 17:13
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int K = 2;
        int[][][] dp = new int[n][K + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = K; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][K][0];
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(data));
    }

}
