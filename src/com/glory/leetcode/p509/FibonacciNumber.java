package com.glory.leetcode.p509;

/**
 * @author zhanggc
 * @date 2022-01-24 22:42:13
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(4));
    }

    static class Solution {
        public int fib(int n) {
            int[] memo = new int[n + 1];
            return helper(memo, n);
        }

        private int helper(int[] memo, int n) {
            // base case
            if (n == 0 || n == 1) {
                return n;
            }
            if (memo[n] != 0) {
                return memo[n];
            }
            memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
            return memo[n];
        }
    }

}
