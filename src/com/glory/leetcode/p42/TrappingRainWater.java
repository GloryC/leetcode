//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2962 👎 0

package com.glory.leetcode.p42;

import java.util.Stack;

/**
 * @author zhanggc
 * @date 2021-12-27 17:19:20
 */
public class TrappingRainWater {

    static class Solution {
        public int trap(int[] height) {
            if (height == null) {
                return 0;
            }

            // 思路：
            // 单调不增栈，walls元素作为右墙依次入栈
            // 出现入栈元素（右墙）比栈顶大时，说明在右墙左侧形成了低洼处，低洼处出栈并结算该低洼处能接的雨水
            Stack<Integer> stack = new Stack<>();
            int ans = 0;
            for (int i = 0; i < height.length; i++) {
                // 栈不为空，且当前元素（右墙）比栈顶（右墙的左侧）大：说明形成低洼处了
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    // 低洼处弹出，尝试结算此低洼处能积攒的雨水
                    int curIdx = stack.pop();
                    // 看看栈里还有没有东西（左墙是否存在）
                    // 有右墙+有低洼+没有左墙=白搭
                    while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        int stackTop = stack.peek();
                        ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                    }
                }
                stack.add(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] data = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.trap(data));
    }

}