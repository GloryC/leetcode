package com.glory.leetcode.p96;

/**
 * @author zhanggc
 * @date 2022-01-18 23:38:43
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        // 备忘录
        int[][] memo;

        public int numTrees(int n) {
            memo = new int[n + 1][n + 1];
            return count(1, n);
        }

        int count(int lo, int hi) {
            // base case
            if (lo > hi) {
                return 1;
            }

            // 查备忘录
            if (memo[lo][hi] != 0) {
                return memo[lo][hi];
            }


            int res = 0;
            for (int i = lo; i <= hi; i++) {
                // i 的值作为根节点 root
                int left = count(lo, i - 1);
                int right = count(i + 1, hi);
                // 左右子树的组合数乘积是 BST 的总数
                res += left * right;
            }

            // 将结果存入备忘录
            memo[lo][hi] = res;
            return res;
        }
    }

}
