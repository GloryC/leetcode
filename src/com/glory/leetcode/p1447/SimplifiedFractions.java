package com.glory.leetcode.p1447;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanggc
 * @date 2022-02-10 22:41:31
 */
public class SimplifiedFractions {

    /**
     * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）
     * 满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
     */
    static class Solution {
        public List<String> simplifiedFractions(int n) {
            List<String> res = new LinkedList<>();
            for (int denominator = 2; denominator <= n; ++denominator) {
                for (int numerator = 1; numerator < denominator; ++numerator) {
                    if (gcd(numerator, denominator) == 1) {
                        res.add(numerator + "/" + denominator);
                    }
                }
            }

            return res;
        }

        public int gcd(int a, int b) {
            return b != 0 ? gcd(b, a % b) : a;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifiedFractions(3));
    }

}
