package p123;

/**
 * @author Glory
 * @date 2020/3/9 17:13
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    public static void main(String[] args) {
        int[] data = {3, 3, 5, 0, 0, 3, 1, 4};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxProfit(data));
    }

}
