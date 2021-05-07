//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1639 👎 0

package com.glory.leetcode.p70;

/**
 * @author zhanggc
 * @date 2021-05-07 14:07:31
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.climbStairs(2));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.climbStairs(2));
    }

    /**
     * 解法1：动态规划
     */
    static class Solution1 {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    /**
     * 解法2：斐波那契求通项
     */
    static class Solution2 {
        public int climbStairs(int n) {
            double sqrt5 = Math.sqrt(5);
            double fibN = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2,n + 1);
            return (int)(fibN / sqrt5);
        }
    }

}