package p309;

/**
 * @author Glory
 * @date 2020/3/24 19:32
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        int dpPre0 = 0;  // 冷冻期
        for (int i = 0; i < n; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dpPre0 - prices[i]);
            dpPre0 = temp;  // 冷冻期赋值
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 0, 2};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(data));
    }

}
