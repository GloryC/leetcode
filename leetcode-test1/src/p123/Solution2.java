package p123;

/**
 * @author Glory
 * @date 2020/3/9 17:13
 */
public class Solution2 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][2][0] = 0;
        dp[0][2][1] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) { /*处理 base case */ }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }

    public static void main(String[] args) {
        int[] data = {3, 3, 5, 0, 0, 3, 1, 4};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxProfit(data));
    }

}
