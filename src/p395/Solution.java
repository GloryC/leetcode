package p395;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Glory
 * @date 2021/2/27 23:28
 */
public class Solution {

    /**
     * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，
     * 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
     *
     * 调用递归（重点）：如果一个字符 cc 在 ss 中出现的次数少于 kk 次，那么 ss
     * 中所有的包含 cc 的子字符串都不能满足题意。所以，应该在 ss 的所有不包含 cc
     * 的子字符串中继续寻找结果：把 ss 按照 cc 分割（分割后每个子串都不包含cc），
     * 得到很多子字符串 tt；下一步要求 tt 作为源字符串的时候，它的最长的满足题意的
     * 子字符串长度（到现在为止，我们把大问题分割为了小问题(ss → tt)）。
     * 此时我们发现，恰好已经定义了函数 longestSubstring(s, k) 就是来解决这个问题的！
     * 所以直接把 longestSubstring(s, k)函数拿来用，于是形成了递归。
     */
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len < k) {
            return 0;
        }

        Map<Character, Integer> counter = new HashMap<>(26);
        for (int i = 0; i < len; i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Character c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(c.toString())) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }

}
