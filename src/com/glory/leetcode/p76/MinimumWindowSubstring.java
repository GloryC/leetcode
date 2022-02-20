package com.glory.leetcode.p76;

import java.util.HashMap;

/**
 * @author zhanggc
 * @date 2022-02-20 22:47:36
 */
public class MinimumWindowSubstring {

    /**
     * 滑动窗口算法的思路是这样：
     * <p>
     * 1、我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，
     * 把索引左闭右开区间 [left, right) 称为一个「窗口」。
     * <p>
     * 2、我们先不断地增加 right 指针扩大窗口 [left, right)，直到窗口中的字符串符合要求（包含了 T 中的所有字符）。
     * <p>
     * 3、此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right)，
     * 直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。
     * 同时，每次增加 left，我们都要更新一轮结果。
     * <p>
     * 4、重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
     * <p>
     * 这个思路其实也不难，第 2 步相当于在寻找一个「可行解」，
     * 然后第 3 步在优化这个「可行解」，最终找到最优解，也就是最短的覆盖子串。
     * 左右指针轮流前进，窗口大小增增减减，窗口不断向右滑动，
     * 这就是「滑动窗口」这个名字的来历。
     */
    static class Solution {

        /**
         * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
         * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
         */
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> need = new HashMap<>(16), window = new HashMap<>(16);
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            // 其中 valid 变量表示窗口中满足 need 条件的字符个数，
            // 如果 valid 和 need.size 的大小相同，则说明窗口已满足条件，已经完全覆盖了串 T。
            int left = 0, right = 0, valid = 0;
            // 记录最小覆盖子串的起始索引及长度
            int start = 0, len = Integer.MAX_VALUE;
            while (right < s.length()) {
                // c 是将移入窗口的字符
                char c = s.charAt(right);
                // 右移窗口
                right++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }
                // 判断左侧窗口是否要收缩
                while (valid == need.size()) {
                    // 在这里更新最小覆盖子串
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    // d 是将移出窗口的字符
                    char d = s.charAt(left);
                    // 左移窗口
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }

            // 返回最小覆盖子串
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

}
