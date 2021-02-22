package p303;

/**
 * @author Glory
 * @date 2020/3/9 19:22
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // 第一个维度是天数，第二个维度表示是否持有股票，0表示不持有，1表示持有，2表示过渡期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 第i天不持有股票的情况有两种
            // a.第i - 1天也不持有股票
            // b.第i - 1天进入冷冻期（i - 1天卖出）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 第i天持有股票有两种情况
            // a.第i - 1天也持有股票
            // b.第i - 1天不持有股票，在第i天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 第i天进入冷冻期只有一种情况，第i - 1天持有股票且卖出（今天卖出）
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }

}
