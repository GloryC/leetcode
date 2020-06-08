package p122;

/**
 * @author Glory
 * @date 2019/11/4 9:38
 */
public class Solution2 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0;  //无股票
        int dp1 = Integer.MIN_VALUE; // 有股票
        for (int i = 0; i < n; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, temp - prices[i]);
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] data = {7, 1, 5, 3, 6, 4};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxProfit(data));
    }

}
