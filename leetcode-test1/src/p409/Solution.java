package p409;

import java.util.Arrays;

/**
 * @author Glory
 * @date 2020/3/19 0:35
 */
public class Solution {
    public int longestPalindrome(String s) {
        int[] data = new int[60];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            data[chars[i] - 'A']++;
        }
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < data.length; i++) {
            count += data[i] / 2 * 2;
            if (!flag && data[i] % 2 == 1) {
                flag = true;
            }
        }
        if (flag){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }
}
