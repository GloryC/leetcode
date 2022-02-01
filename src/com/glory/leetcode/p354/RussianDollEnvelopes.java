package com.glory.leetcode.p354;

import java.util.Arrays;

/**
 * @author zhanggc
 * @date 2022-02-01 17:32:44
 */
public class RussianDollEnvelopes {

    /**
     * 先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序。之后把所有的 h 作为一个数组，
     * 在这个数组上计算 LIS 的长度就是答案。
     *
     * exceed time limit
     */
    static class Solution {

        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            // 按宽度升序排列，如果宽度一样，则按高度降序排列
            Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

            // 对高度数组寻找LIS
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int res = 0;
            for (int value : dp) {
                res = Math.max(res, value);
            }

            return res;
        }

    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Solution solution = new Solution();
        System.out.println(solution.maxEnvelopes(envelopes));
    }

}
