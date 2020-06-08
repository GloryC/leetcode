package p714;

/**
 * @author Glory
 * @date 2020/3/9 19:29
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 第i天不持有股票的情况有两种
            // a.第i - 1天也不持有股票
            // b.第i天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            // 第i天持有股票有两种情况
            // a.第i - 1天也持有股票
            // b.第i - 1天不持有股票，在第i天买入(手续费算在卖出)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {1, 3, 2, 8, 4, 9};
        System.out.println(solution.maxProfit(data, 2));
    }

}
