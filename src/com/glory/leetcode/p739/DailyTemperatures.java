package com.glory.leetcode.p739;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhanggc
 * @date 2022-02-04 13:18:11
 */
public class DailyTemperatures {

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];
            Stack<Integer> s = new Stack<>();
            for (int i = temperatures.length - 1; i >= 0; i--) {
                // 注意temperatures[s.peek()]，s.peek()存储的是索引值
                while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                    // 矮个起开，反正也被挡着了。。。
                    s.pop();
                }

                // 得到索引间距
                res[i] = s.empty() ? 0 : (s.peek() - i);
                // 将索引值入栈
                s.push(i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

}
