package p714;

/**
 * @author Glory
 * @date 2020/3/9 19:29
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp_i_0;  // i-1时的状态
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, temp - price - fee);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {1, 3, 2, 8, 4, 9};
        System.out.println(solution.maxProfit(data, 2));
    }

}
