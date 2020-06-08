package p124;

/**
 * @author Glory
 * @date 2020/3/9 17:33
 */
public class Solution {

    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        int[] buyDp = new int[k + 1];
        int[] sellDp = new int[k + 1];

        int len = prices.length;
        //k>len/2,也就是可以无限制交易了，贪心算法
        if (k > len / 2) {
            int dp = 0;
            for (int i = 0; i < len - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    dp = dp + prices[i + 1] - prices[i];
                }
            }
            return dp;
        }

        for (int i = 1; i <= k; i++) {
            buyDp[i] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                /*
                 对于任意一天考虑四个变量:
                 fstBuy: 在该天第一次买入股票可获得的最大收益
                 fstSell: 在该天第一次卖出股票可获得的最大收益
                 secBuy: 在该天第二次买入股票可获得的最大收益
                 secSell: 在该天第二次卖出股票可获得的最大收益
                 分别对四个变量进行相应的更新, 最后secSell就是最大
                 收益值(secSell >= fstSell)
                 去掉second的部分，就是只卖一次的解法
                 */
                buyDp[i] = Math.max(buyDp[i], sellDp[i - 1] - price);
                sellDp[i] = Math.max(sellDp[i], buyDp[i] + price);
            }
        }
        return sellDp[k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {3, 2, 6, 5, 0, 3};
        System.out.println(solution.maxProfit(2, data));
    }

}
