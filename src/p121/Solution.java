package p121;

/**
 * @author Glory
 * @date 2019/10/24 8:41
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            // you can only buy once
            dp_i_1 = Math.max(dp_i_1, -price);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
