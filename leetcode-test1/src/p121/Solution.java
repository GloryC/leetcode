package p121;

/**
 * @author Glory
 * @date 2019/10/24 8:41
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
