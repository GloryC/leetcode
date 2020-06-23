package p309;

/**
 * @author Glory
 * @date 2020/3/24 19:32
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;       // 冷冻期
        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - price);
            dp_pre_0 = temp;    // 冷冻期为上一次为0的时候
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 0, 2};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(data));
    }

}
