package p121;

/**
 * @author Glory
 * @date 2020/3/24 18:42
 */
public class Solution3 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0;  // 无股票
        int dp1 = Integer.MIN_VALUE;  // 有股票
        for (int i = 0; i < n; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]);  // 只有一次买的机会
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] data = {7, 1, 5, 3, 6, 4};
        Solution3 solution2 = new Solution3();
        System.out.println(solution2.maxProfit(data));
    }

}

