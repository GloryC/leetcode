package com.glory.leetcode.p583;

/**
 * @author zhanggc
 * @date 2022-02-07 21:32:24
 */
public class DeleteOperationForTwoStrings {

    static class Solution {
        /**
         * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
         * 每步 可以删除任意一个字符串中的一个字符。
         * <p>
         * 删除的结果不就是它俩的最长公共子序列嘛！
         */
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int lcs = longestCommonSubsequence(word1, word2);
            return (m - lcs) + (n - lcs);
        }

        private int longestCommonSubsequence(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            // 定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
            // 目标：s1[0..m-1] 和 s2[0..n-1] 的 lcs 长度，即 dp[m][n]
            // base case: dp[0][..] = dp[..][0] = 0
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 现在 i 和 j 从 1 开始，所以要减一
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        // s1[i-1] 和 s2[j-1] 必然在 lcs 中
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        // s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }

            return dp[m][n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("sea", "eat"));
    }

}
