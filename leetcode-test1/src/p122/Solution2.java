package p122;

/**
 * @author Glory
 * @date 2019/11/4 9:38
 */
public class Solution2 {

    public int maxProfit(int[] prices) {
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
        int[] data = {7, 1, 5, 3, 6, 4};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxProfit(data));
    }

}
