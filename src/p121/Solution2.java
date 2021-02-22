package p121;

/**
 * @author Glory
 * @date 2020/3/24 18:42
 */
public class Solution2 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        int[] data = {7, 1, 5, 3, 6, 4};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.maxProfit(data));
    }

}

