package com.glory.leetcode.p72;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanggc
 * @date 2022-01-28 20:49:05
 */
public class EditDistance {

    static class Solution {

        Map<String, Integer> memo = new HashMap<>();

        public int minDistance(String word1, String word2) {
            return dp(word1, word2, word1.length() - 1, word2.length() - 1);
        }

        private int dp(String s1, String s2, int i, int j) {
            // base case
            if (i == -1) {
                return j + 1;
            }
            if (j == -1) {
                return i + 1;
            }

            String index = i + "," + j;

            if (memo.containsKey(index)) {
                return memo.get(index);
            }

            if (s1.charAt(i) == s2.charAt(j)) {
                memo.put(index, dp(s1, s2, i - 1, j - 1));
            } else {
                // 插入
                // 删除
                // 替换
                memo.put(index, Math.min(dp(s1, s2, i - 1, j) + 1,
                        Math.min(dp(s1, s2, i, j - 1) + 1,
                                dp(s1, s2, i - 1, j - 1) + 1)));
            }
            return memo.get(index);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("intention", "execution"));
    }

}
