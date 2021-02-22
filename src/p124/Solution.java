package p124;

/**
 * @author Glory
 * @date 2020/3/9 17:33
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        if (k > n / 2)
            return maxProfit_k_inf(prices);

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    private int maxProfit_k_inf(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            // 上一次为空的时候
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, temp - price);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {3, 2, 6, 5, 0, 3};
        System.out.println(solution.maxProfit(2, data));
    }

}
