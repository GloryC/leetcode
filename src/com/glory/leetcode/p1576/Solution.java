package com.glory.leetcode.p1576;

/**
 * @author Glory
 * @date 2022/1/5 23:48
 */
public class Solution {

    private char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('?' == c) {
                sb.append(getCharacter(i == 0 ? ' ' : sb.charAt(i - 1), i != (s.length() - 1) ? s.charAt(i + 1) : ' '));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private char getCharacter(char left, char right) {
        for (char c : chars) {
            if (c != left && c != right) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.modifyString("j?qg??b"));
    }

}
